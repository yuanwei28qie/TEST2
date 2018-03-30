package com.microsilver.mrcard.serviceplatform.core.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.core.exception.CloudErrorDecoder
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年9月20日 下午5:27:05
 * @Copyright Micro Silver
 *
 */

public class CloudErrorDecoder implements ErrorDecoder{
	private final static Logger logger = LoggerFactory.getLogger(CloudErrorDecoder.class);
	final Decoder decoder;
    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    CloudErrorDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            return (Exception) decoder.decode(response, CloudErrorDecoder.class);
        } catch (IOException fallbackToDefault) {
            return defaultDecoder.decode(methodKey, response);
        }
    }
}
