package com.microsilver.mrcard.cloud.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 
 * @Name com.microsilver.mrcard.clour.finance.Application
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月13日 上午10:51:52
 * @Copyright Micro Silver
 *
 */
@MapperScan("com.microsilver.mrcard.cloud.finance")
@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
public class Application {
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }  
}
