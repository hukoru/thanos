package com.thanos.api.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 날짜 관련 유틸 클래스
 * @author 임세환
 *
 */
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static String getTodayYYYYMMDDHHMMSS(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentDatetime = simpleDateFormat.format(new Date());
        return currentDatetime;
    }

    public static String getWeekDay() {
        Calendar c = Calendar.getInstance();

        int day = c.get(c.DAY_OF_MONTH);

        final String[] weekDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        return weekDay[c.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static String getToday(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
        Date currentTime = new Date();
        return formatter.format(currentTime);
    }

    public static String getToday() {
        return getToday("yyyyMMdd");
    }

    public static String getTodayAnothertFormat() {
        return getToday("yyyy-MM-dd");
    }

    public static String getTodayThirdFormat() {
        return getToday("yyyy/MM/dd");
    }

    public static String getFormatTime(String stringDate){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        try {
            date = format.parse(stringDate);
        } catch (ParseException e) {
            log.debug(e.toString());
        }

        String msg;

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");

        long curTime = System.currentTimeMillis();
        long regTime =  date.getTime();

        long diffTime = (curTime - regTime) / 1000;

        if (diffTime < TIME_MAXIMUM.SEC) {
            // sec
            msg = "방금 전";
        } else if ((diffTime /= TIME_MAXIMUM.SEC) < TIME_MAXIMUM.MIN) {
            // min
            msg = diffTime + "분 전";
        } else if ((diffTime /= TIME_MAXIMUM.MIN) < TIME_MAXIMUM.HOUR) {
            // hour
            msg = (diffTime) + "시간 전";
        } else if ((diffTime /= TIME_MAXIMUM.HOUR) < TIME_MAXIMUM.DAY) {
            // day
            //   msg = (diffTime) + "일 전";
            msg = transFormat.format(date);
        } else if ((diffTime /= TIME_MAXIMUM.DAY) < TIME_MAXIMUM.MONTH) {
            // day
            // msg = (diffTime) + "달 전";
            msg = transFormat.format(date);
        } else {
            //   msg = (diffTime)-12 + "년 전";
            msg = transFormat.format(date);
        }

        return msg;


    }


    /**
     * 결제시 받은 expries date
     *
     * @param dateLong
     * @return
     */
    public static String getDate(Long dateLong) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateLong);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
        String result = formatter.format(cal.getTime());

        return result;
    }

    public static String payEndDate(int month){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DATE, -1);

        Date date = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA);


        return formatter.format(date);
    }

    private static class TIME_MAXIMUM {
        public static final int SEC = 60;
        public static final int MIN = 60;
        public static final int HOUR = 24;
        public static final int DAY = 30;
        public static final int MONTH = 12;
    }

    /**
     * 만료일과 오늘날짜를 비교
     * @param receiveExpiryDate
     * @return
     * @throws ParseException
     */
    public static int compareDate(String receiveExpiryDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date receiveDate = simpleDateFormat.parse(receiveExpiryDate);
        Date toDay = simpleDateFormat.parse(DateUtil.getTodayYYYYMMDDHHMMSS());
        return receiveDate.compareTo(toDay);
    }


}
