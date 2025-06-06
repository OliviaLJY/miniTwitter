package com.example.mytwitter.util;

import org.springframework.beans.BeanUtils;

public class CopyUtil {

    public static <T> T copy(Object source, Class<T> clazz){
        if(source == null){
            return null;
        }
        T obj = null;
        try{
            obj = clazz.newInstance();
        } catch (Exception e){
            e.printStackTrace();;
            return null;
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }
}
