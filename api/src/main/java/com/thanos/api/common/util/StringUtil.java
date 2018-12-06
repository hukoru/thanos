package com.thanos.api.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 공통 String Util
 * org.apache.commons.lang.StringUtils 상속후 필요 메소드 추가
 * 자세한 기타 자세한 스펙은 org.apache.commons.lang.StringUtils 참조
 * (url : http://jakarta.apache.org/commons/lang/api-release/org/apache/commons/lang/StringUtils.html)
 */
public class StringUtil extends StringUtils {

    public static String nullToEmpty(String value){
        ;
        if(value == null || value.equals("")){
            value   =   "";
        }
        return value;
    }

    public static int nullToZero(String value){

        if(value == null || value.equals("")){
            return 0;
        }
        return Integer.parseInt(value);
    }

    public static int convertOverAge(String birthYear, int age) {
        if (birthYear.equals("1900")) {
            return 1900;
        }else {
            return age;
        }

    }
    public static boolean isEmptyAndSpaceCheck(String spaceCheck) {

        if(StringUtil.isEmpty(spaceCheck)) return true;
        for (int i = 0; i < spaceCheck.length(); i++) {
            if (spaceCheck.charAt(i) == ' ')
                return true;
        }
        return false;
    }


}
