package com.microsilver.mrcard.scheduledtask.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.HttpClientUtils;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import com.microsilver.mrcard.scheduledtask.dao.IMemberDao;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMember;
import com.microsilver.mrcard.scheduledtask.model.ImsSysRemind;
import com.microsilver.mrcard.scheduledtask.model.RespBaseDto;
import com.microsilver.mrcard.scheduledtask.service.BaseService;
import com.microsilver.mrcard.scheduledtask.service.ImsSysRemindService;
import com.microsilver.mrcard.scheduledtask.service.MQService;

/**
 * 活动定时任务
 */
@Component
@Lazy(value = false)
public class RemindJob extends BaseService{
	
	@Autowired
	private ImsSysRemindService imsSysRemindService;
	
	@Resource
	private IMemberDao memberDao;
	
	@Resource
	private MQService service;
	
	/**
	 * 超级订活动开始前房间开抢提醒
	 * 每小时的55分开始检查下一整点是否有提醒
	 */
	@Scheduled(cron = "${REG_REMIND}")
	public void remindCustomer () {
		logger.info("定时提醒任务开始");
		try {
		List<ImsSysRemind> listNextTimeRemind = imsSysRemindService.listNextTimeRemind();
		for (ImsSysRemind remind : listNextTimeRemind) {
			Long memberId = remind.getMemberId();
			ImsEweiShopMember member = memberDao.selectByPrimaryKey(memberId);
			
			PushMsg msg = new PushMsg();
			msg.setPushType(remind.getRemindWay());
			msg.setPhone(member.getMobile());
			msg.setTemplateType(43526);
			msg.setAppType((byte)4);//APP类型 1:卡先生消费者版本 2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠
			logger.info(String.format("给用户 %s 发送提醒短信", member.getMobile()));
			RespBaseDto res = service.pushMessageToMQForFeign(msg);
			if(res.getState()==0) {
				logger.info(String.format("短信发送成功,删除ID为%s的提醒记录",remind.getId()));
				imsSysRemindService.deleteByPrimaryKey(remind.getId());
			}
			
//			Map<String,String> map = new HashMap<String,String>();
//			map.put("pushType", remind.getRemindWay()+"");
//			map.put("phone", member.getMobile());
//			map.put("templateType", 43526+"");
//			map.put("appType","4");//APP类型 1:卡先生消费者版本 2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠
//			logger.info(String.format("给用户 %s 发送提醒短信", member.getMobile()));
//			String doPost = HttpClientUtils.doPost(SystemProperties.HTTP_URL+"/api/Common/pushMessageToMQ", map,null);
//			Map result = JSON.parseObject(doPost, Map.class);
//			if(result.containsKey("state")){
//				Object object = result.get("state");
//				if(object instanceof Integer && (Integer)object == 0){
//					logger.info(String.format("短信发送成功,删除ID为%s的提醒记录",remind.getId()));
//					imsSysRemindService.deleteByPrimaryKey(remind.getId());
//				}
//			}
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
