package com.microsilver.im.client.packet;

public class MessageBean {
	private String command;
	private String msgId;
	private String formId;
	private String toId;
	private Content content;


	public MessageBean createCopy() {
		MessageBean copy = new MessageBean();
		copy.command = this.command;
		copy.msgId = this.msgId;
		copy.formId = this.formId;
		copy.toId = this.toId;
		copy.content = this.content;
		return copy;
	}

	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	
}
