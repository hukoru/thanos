package com.thanos.api.common;

/**
 * Created by Jang on 2016-05-16.
 */
public class StringUtil {

    public final static String EMPTY_STRING = "";

    public static boolean isEmpty(String input) {
        boolean returnBoolean = false;
        if(input == null || input.trim().equals(EMPTY_STRING)){
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static int onlyNum(String str) {
        if ( str == null ) return 0;

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if( Character.isDigit( str.charAt(i) ) ) {
                sb.append( str.charAt(i) );
            }
        }
        return Integer.parseInt(sb.toString());
    }


    public static String toString(String str) {
        if ( str == null ) return "";
        return str;
    }

    public static String upperCase(String str) {
        return str == null?null:str.toUpperCase();
    }

    public static String lowerCase(String str) {
        return str == null?null:str.toLowerCase();
    }

    public static boolean isBlank(String s) {
        if (isEmpty(s)) {
            return true;
        }

        if (isEmpty(s.trim())) {
            return true;
        }

        return false;
    }
}
