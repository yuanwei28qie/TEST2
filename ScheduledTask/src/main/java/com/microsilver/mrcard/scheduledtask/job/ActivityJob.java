package com.microsilver.mrcard.scheduledtask.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.scheduledtask.service.ShopActivityGoodsService;

/**
 * 活动定时任务
 */
@Component
@Lazy(value = false)
public class ActivityJob{
	
	@Autowired
	private ShopActivityGoodsService shopActivityGoodsService;
	
	/**
	 * 超级订活动结束更新库存 时间信息(零点半价和超级特价)
	 * 每天0点到23点检测
	 */

	@Scheduled(cron = "${REG_ACIVITY} ")
	public void updateActivity () {
		List<ImsEweiShopActivityGoods> allActivityGoods = shopActivityGoodsService.getSuperOrderActivityGoods();
		try {
			if(allActivityGoods != null){
				shopActivityGoodsService.updateActivityGoods(allActivityGoods);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
