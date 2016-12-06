package com.zeyu.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
public @interface Permission {  
  
    /** 
     * 角色ID，该角色ID，对应数据库中的角色ID 
     * @return 
     * @version V1.0.0 
     * @date Jan 13, 2014 4:59:35 PM 
     */  
    String[] value();  
      
} 
