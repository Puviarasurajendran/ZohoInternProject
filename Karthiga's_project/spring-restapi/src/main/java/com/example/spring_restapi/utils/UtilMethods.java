package com.example.spring_restapi.utils;

public class UtilMethods {

	public static boolean isWrapperType(Class<?> clazz) {
        return clazz.equals(Boolean.class) ||
               clazz.equals(Byte.class) ||
               clazz.equals(Character.class) ||
               clazz.equals(Short.class) ||
               clazz.equals(Integer.class) ||
               clazz.equals(Long.class) ||
               clazz.equals(Float.class) ||
               clazz.equals(Double.class)||
               clazz.equals(String.class);
    }
}
