package com.async.asyncMuseum.util;

import org.springframework.beans.BeanUtils;

public class MyUtil {
    public static <S,T> T convert(S s, T t){
        BeanUtils.copyProperties(s,t);
        return t;
    }
}
