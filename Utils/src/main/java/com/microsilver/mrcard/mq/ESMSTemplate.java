package com.microsilver.mrcard.mq;

/**
 * @Name com.microsilver.mrcard.serviceplatform.model.enums.ESMSTemplate
 * @Description 短信接口模板及编号定义
 * @Author Jade
 * @Version 2017/9/12
 * @Copyright Micro Silver
 */
public enum ESMSTemplate {

    /**
     * 45235	【超级订】您的订单状态异常，退款将在1-3个工作日内原路返回您的支付账户中。
     * 45229	【超级订】您的验证码是#code#。如非本人操作，请忽略本短信
     * 44253	【超级订】亲，您已成功预定#hotel#，请在入住时间内及时到酒店办理入住手续。
     * 44214	【超级订】亲，您的#home#房间有一个#type#的订单，请注意查收
     * 43526	【超级订】亲，您预约提醒的酒店房间现在还有5分钟即将开放，请抓紧时间抢订
     * 43405	【超级订】尊敬的超级订商家，您的提现金额将在2小时左右到账，请及时查收
     * 46759	【超级订】#user_name#[#user_phone#]酒店电话#hotel_phone#酒店#hotel#房间#room#于#time#入住，请及时处理	未审核	无	[编辑] [删除]
     * <p>
     * 45230	【小飞侠】您的验证码是#code#。如非本人操作，请忽略本短信
     * 44203	【小飞侠】您上周的收入已为您结算，将在3个工作日内到账，请耐心等待。
     * 44202	【小飞侠】您的提现申请已提交，请耐心等候，我们将在最短的时间内给您到账。
     * <p>
     * 34903	【卡先生】亲爱的#name#,用户#user_name#已支付金额#money#,订单号为#orderid#,请及时处理.
     * 34716	【卡先生】亲爱的#name#,用户#user_name#已确认收货,订单号为:#order#,请注意查看.
     * 34713	【卡先生】亲爱的#name#,用户#user_name#已支付金额#money#,请及时处理订单.
     * 33301	【卡先生】正在找回密码，您的验证码是#code#
     * 31705	【卡先生】您的验证码是#code#。如非本人操作，请忽略本短信
     */

    //卡先生
    SMS_CARD_CHECKCODE("#code#=%s", 31705),
    SMS_CARD_PAYORDER_REMIND("#name#=%s&#user_name#=%s&#money#=%s&#orderid#=%s", 34903),
    SMS_CARD_PAYORDER_REMIND2("#name#=%s&#user_name#=%s&#money#=%s", 34713),
    SMS_CARD_RECEIVE_ORDER("#name#=%s&#user_name#=%s&#orderid#=%s", 34716),
    SMS_CARD_FIND_PWD("#code#=%s", 33301),

    //骑士
    SMS_KNIGHT_CHECKCODE("#code#=%s", 45230),
    SMS_KNIGHT_CARRYOVER("", 44203),
    SMS_KNIGHT_WITHDRAW("", 44202),

    //超级定
    SMS_HOTEL_ORDER_EXCEPTION("", 45235),
    SMS_HOTEL_CHECKCODE("#code#=%s", 45229),
    SMS_HOTEL_BUY_SUCCESS("#hotel#=%s", 44253),
    SMS_HOTEL_TYPE_SUCCESS("#home#=%s&#type#=%s", 44214),
    SMS_HOTEL_REMIND("", 43526),
    SMS_HOTEL_WITHDRAW("", 43405),
    SMS_CUSTOMER_SERVICE("#user_name#=%s&#user_phone#=%s&#hotel_phone#=%s&#hotel#=%s&#room#=%s&#time#=%s", 46759)

    ;
    protected String value;
    protected int tplId;

    private ESMSTemplate(String value, int tplId) {
        this.value = value;
        this.tplId = tplId;
    }

    /**
     * 有参数的传参数，从前往后依次传递
     *
     * @param args
     * @return
     */
    public String getValue(String... args) {
        return String.format(this.value, args);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTplId() {
        return tplId;
    }

    public void setTplId(int tplId) {
        this.tplId = tplId;
    }

    /**
     * apptype:1:卡先生消费者版本2:卡先生商家版3:卡先生雇员版4:超级订消费者版5:小飞侠骑士版
     * bussType:验证码类型(1:注册,2：登录,3:修改密码；4：提现验证)
     * time：2018.03.16
     */
    public static ESMSTemplate valueOf(int appType, int bussType) {
        if ((appType == 1 || appType == 2 || appType == 3) && (bussType == 1 || bussType == 2 || bussType == 3)) {
            return SMS_CARD_CHECKCODE;
        }
        if ((appType == 4 || appType == 6) && (bussType == 1 || bussType == 2 || bussType == 3 || bussType == 4)) {
            return SMS_HOTEL_CHECKCODE;
        }
        if ((appType == 5) && (bussType == 1 || bussType == 2 || bussType == 3)) {
            return SMS_KNIGHT_CHECKCODE;
        }
        return null;
    }

    public static ESMSTemplate valueOf(int tplId) {
        if (tplId == 31705) {
            return SMS_CARD_CHECKCODE;
        }
        if (tplId == 34903) {
            return SMS_CARD_PAYORDER_REMIND;
        }
        if (tplId == 34713) {
            return SMS_CARD_PAYORDER_REMIND2;
        }
        if (tplId == 34716) {
            return SMS_CARD_RECEIVE_ORDER;
        }
        if (tplId == 33301) {
            return SMS_CARD_FIND_PWD;
        }
        if (tplId == 45230) {
            return SMS_KNIGHT_CHECKCODE;
        }
        if (tplId == 44203) {
            return SMS_KNIGHT_CARRYOVER;
        }
        if (tplId == 44202) {
            return SMS_KNIGHT_WITHDRAW;
        }
        if (tplId == 45235) {
            return SMS_HOTEL_ORDER_EXCEPTION;
        }
        if (tplId == 45229) {
            return SMS_HOTEL_CHECKCODE;
        }
        if (tplId == 44253) {
            return SMS_HOTEL_BUY_SUCCESS;
        }
        if (tplId == 44214) {
            return SMS_HOTEL_TYPE_SUCCESS;
        }
        if (tplId == 43526) {
            return SMS_HOTEL_REMIND;
        }
        if (tplId == 43405) {
            return SMS_HOTEL_WITHDRAW;
        }
        if (tplId == 46759) {
            return SMS_CUSTOMER_SERVICE;
        }
        return null;
    }


}
