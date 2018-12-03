package com.thanos.api.common.util;


import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommonUtil {

	private static final Random generator = new Random();

	/**
	 * 임시패스워드 생성
	 * @return
	 */
	public static int generatePasswordPin() {
		return 100000 + generator.nextInt(900000);
	}



	/**
	 * 상대방 성별구하기
	 * @param gender
	 * @return
	 */
	public static String getPartnerGender(String gender) {
		if(("M").equals(gender))	return "F";
		else 					return "M";
	}


	/**
	 * Empty 여부
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj){
		boolean result = false;

		if(obj == null){
			return true;
		} else {
			if (obj instanceof String) {
				if ("".equals(obj.toString().trim())) result = true;
			} else if (obj instanceof List) {
				if (((List) obj).isEmpty()) result = true;
			} else if (obj instanceof Map) {
				if(((Map) obj).isEmpty()) result = true;
			} else if (obj instanceof Object[]) {
				if(Array.getLength(obj) == 0) result = true;
			} else {
				result = false;
			}

			return result;
		}
	}

	/**
	 * Not Empty 여부
	 * @param obj
	 * @return
	 */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     *
     * @param str
     * @return
     */
    public static String getURLDecodePercentProcess(String str, String deviceOS) {
    	if(("android").equals(deviceOS))	return str;
    	else					    	return str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B");
    }


	public static String currentDate(){
		LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();
		return LOCAL_DATE_TIME.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

}
