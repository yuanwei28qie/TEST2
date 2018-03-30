package com.microsilver.mrcard.cloud.finance;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.ServletInitializer
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月26日 下午2:29:55
 * @Copyright Micro Silver
 *
 */
public class ServletInitializer extends SpringBootServletInitializer{

	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  
}
