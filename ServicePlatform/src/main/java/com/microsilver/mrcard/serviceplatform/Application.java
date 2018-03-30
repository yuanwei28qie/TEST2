package com.microsilver.mrcard.serviceplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.Application
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月26日 下午1:23:29
 * @Copyright Micro Silver
 *
 */
@MapperScan("com.microsilver.mrcard.serviceplatform")
@ServletComponentScan
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@PropertySource(value= {"classpath:system-config.properties"})
public class Application {
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  

    }
	
}
