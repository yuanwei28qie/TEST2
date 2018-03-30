package com.microsilver.mrcard.scheduledtask.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import com.alibaba.fastjson.JSON;

public class MQUtil {

	public static <T> T fromMessage(Message message, Class<T> cls) {
		T msg = null;
		String contentType = message.getMessageProperties().getContentType();
		if (contentType.equals(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)) {
			// string —— 对应JSON
			msg = JSON.parseObject(new String(message.getBody()), cls);
		} else if (contentType.equals(MessageProperties.CONTENT_TYPE_BYTES)) {
			// 可以使用protobuf这种二进制的序列化
		} else if (contentType.equals(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT)) {
			// 这种直接序列化对象的最好不要用，版本不一致可能序列化不回来
		}

		return msg;
	}
}
