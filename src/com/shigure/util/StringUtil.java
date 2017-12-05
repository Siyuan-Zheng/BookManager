package com.shigure.util;

public class StringUtil {

    //判断字符串是否为空
    public static boolean isEmpty(String str){
        return "".equals(str) || str == null;
    }

    //判断字符串是否为空
    public static boolean isNotEmpty(String str){
        return !"".equals(str) && str != null;
    }
}
