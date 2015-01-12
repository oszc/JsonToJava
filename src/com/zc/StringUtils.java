package com.zc;

/**
 * 1/7/15  7:01 PM
 * Created by JustinZhang.
 */
public class StringUtils {
    public static boolean isEmpty(String s){
        if(s==null || s.length() == 0 ){
            return true;
        }
        return false;
    }
}
