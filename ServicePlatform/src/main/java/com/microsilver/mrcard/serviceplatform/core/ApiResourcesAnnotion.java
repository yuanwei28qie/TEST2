package com.microsilver.mrcard.serviceplatform.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.microsilver.mrcard.serviceplatform.model.enums.EEmployeeRole;

@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface ApiResourcesAnnotion {
	public String uri();
	public EEmployeeRole[] role();
	public String name();
}
