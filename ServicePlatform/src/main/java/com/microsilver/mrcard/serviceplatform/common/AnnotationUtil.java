package com.microsilver.mrcard.serviceplatform.common;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microsilver.mrcard.serviceplatform.core.ApiResourcesAnnotion;
import com.microsilver.mrcard.serviceplatform.model.enums.EEmployeeRole;  

public class AnnotationUtil {
	private static Map<String,EEmployeeRole[]> accessURIFilter = new HashMap<>();
	
	public static void validAnnotation(List<Class<?>> clsList){  
        if (clsList != null && clsList.size() > 0) {  
            for (Class<?> cls : clsList) {  
                //获取类中的所有的方法  
                Method[] methods = cls.getDeclaredMethods();  
                if (methods != null && methods.length > 0) {  
                    for (Method method : methods) {  
                    	ApiResourcesAnnotion apiAnnotion = (ApiResourcesAnnotion) method.getAnnotation(ApiResourcesAnnotion.class);  
                        if (apiAnnotion != null) {  
                        	accessURIFilter.put(apiAnnotion.uri(), apiAnnotion.role());
                        }  
                    }  
                }  
            }  
        }  
    }  
	public static Map<String,EEmployeeRole[]> getAccessURIFilter(){
		return accessURIFilter;
	}
}
