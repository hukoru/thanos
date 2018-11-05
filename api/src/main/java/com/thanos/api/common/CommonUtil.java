package com.thanos.api.common;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {
	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 상대방 성별구하기
	 * @param gender
	 * @return
	 */
	public static String getPartnerGender(String gender) {
		if(gender.equals("M"))	return "F";
		else 					return "M";
	}

	/**
	 *
	 * @param sessionUserId
	 * @param fromUserId
	 * @param toUserId
	 * @return
	 */
	public static int getPartnerId(int sessionUserId, int fromUserId, int toUserId) {
		if(sessionUserId == fromUserId)		return toUserId;
		else								return fromUserId;
	}

	/**
	 * List Null 여부 체크
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List isNullList(List list) {
		if(list != null)	return list;
		else				return new ArrayList();
	}

	/**
	 *
	 * @param pageIndex
	 * @return
	 */
	public static int getLimitStart(int pageIndex, int pageSize) {
		return (pageIndex-1) * pageSize;
	}

	/**
	 * 푸시발송여부
	 * @param joinYn
	 * @return
	 */
	public static boolean isPush(String joinYn) {
		boolean result = false;
		switch(joinYn) {
			case "S":	result = true;	break;
			case "Y":	result = true; 	break;
            case "C":	result = true; 	break;
		}
		return result;
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
    	if(deviceOS.equals("android"))	return str;
    	else					    	return str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B");
    }

    /**
     *
     * @param age
     * @return
     */
    public static int getBirthYear(int age) {
    	String yyyy = DateUtil.getToday("yyyy");
    	return Integer.parseInt(yyyy) - (age - 1);
    }

	public static String getTodayTime(){
		long time = System.currentTimeMillis();
		SimpleDateFormat ctime = new SimpleDateFormat("HH:mm:ss");
		String CurrentTime = ctime.format(new Date(time));
		return CurrentTime;
	}

	public static String getTodayYYYYMMDDHHMMSS(){
		String currentDatetime = simpleDateFormat.format(new Date());
		return currentDatetime;
	}

	/**
	 * 범위안에 임의값 리턴
	 * @param min 최소값
	 * @param max 최대값
	 * @return 임의값
	 */
	public static int getRandomOne(int min, int max){
		return new Random().ints(min, max+1).limit(1).findFirst().getAsInt();
	}

	/**
	 * 확률계산하여 결과리턴
	 * @param percent
	 * @return
	 */
	public static boolean chanceForPercent(float percent){
		double d = Math.random() * 100;
		return ( d <= percent );
	}

}
