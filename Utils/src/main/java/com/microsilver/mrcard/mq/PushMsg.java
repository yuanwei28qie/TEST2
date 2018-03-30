package com.microsilver.mrcard.mq;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

// 推送消息
public class PushMsg {
	// 推送消息种类 0 JPUSH / 1 短信 / 2 JPUSH和短信
	@ApiModelProperty(value = "推送消息种类 0 JPUSH / 1 短信 / 2 JPUSH和短信")
	private int pushType;

	// JPUSH 用戶别名(唯一的)
	@ApiModelProperty(value = "JPUSH 用戶别名(唯一的)")
	private String alias;
	//推送 注册id
	@ApiModelProperty(value = "推送 注册id")
	private String registration;


	// JPUSH 群组名
	@ApiModelProperty(value = "JPUSH 群组名")
	private List<String> tagValues;

	// JPUSH 通知内容
	@ApiModelProperty(value = "JPUSH 通知内容")
	private String title;

	//终端类型(1:android,2:ios)
	@ApiModelProperty(value = "终端类型(1:android,2:ios)")
	private Byte device;

	@ApiModelProperty(value = "APP类型 1:卡先生消费者版本 2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠  6:超级订商家版")
	private Byte appType;

	// 消息內容(可能要定义具体的消息实体，后面再改)
	@ApiModelProperty(value = "消息內容")
	private ExtraContent content;

	// 短信 手机号
	@ApiModelProperty(value = "短信 手机号")
	private String phone;

	@ApiModelProperty(value = "短信模板编号")
	private Integer templateType;

	@ApiModelProperty(value = "短信模板参数 通过ExtraSMS.ExtraSMSValueByTemplateId()获取参数值")
	private ExtraSMS extraSMS;

	public int getPushType() {
		return pushType;
	}

	public void setPushType(int pushType) {
		this.pushType = pushType;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public List<String> getTagValues() {
		return tagValues;
	}

	public void setTagValues(List<String> tagValues) {
		this.tagValues = tagValues;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Byte getDevice() {
		return device;
	}

	public void setDevice(Byte device) {
		this.device = device;
	}

	public Byte getAppType() {
		return appType;
	}

	public void setAppType(Byte appType) {
		this.appType = appType;
	}

	public ExtraContent getContent() {
		return content;
	}

	public void setContent(ExtraContent content) {
		this.content = content;
	}

	public Integer getTemplateType() {
		return templateType;
	}

	public void setTemplateType(Integer templateType) {
		this.templateType = templateType;
	}

	public ExtraSMS getExtraSMS() {
		return extraSMS;
	}

	public void setExtraSMS(ExtraSMS extraSMS) {
		this.extraSMS = extraSMS;
	}

	@Override
	public String toString() {
		return "PushMsg [pushType=" + pushType + ", alias=" + alias + ", registration=" + registration + ", tagValues="
				+ tagValues + ", title=" + title + ", device=" + device + ", content=" + content + ", phone=" + phone
				+ ", templateType=" + templateType + ", extraSMS=" + extraSMS + "]";
	}
	
}
