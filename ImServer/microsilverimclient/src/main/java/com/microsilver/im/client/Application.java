/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsilver.im.client;


import com.microsilver.im.client.netty.ImRepository;
import com.microsilver.im.client.netty.ImExculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;


/**
 * Spring Java Configuration and Bootstrap
 *
 * @author  Jade
 */
@SpringBootApplication
@PropertySource(value = "classpath:/imclient.properties")
public class Application {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ImExculator ex = context.getBean(ImExculator.class);

        ex.start();

    }

    @Bean(name = "imRepository")
    public ImRepository imRepository(){
        return new ImRepository();
    }


}