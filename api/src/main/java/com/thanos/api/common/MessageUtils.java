package com.thanos.api.common;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageUtils {


    private static MessageSource messageSource;
/*

    public static Locale convertByCountryCode(String value){

        if(value.equals("US")){
            return new Locale.Builder().setLanguage("en").setRegion("US").build();
        }else if(value.equals("KR")){
            return new Locale.Builder().setLanguage("ko").setRegion("KR").build();
        }else if(value.equals("MY")){
            return new Locale.Builder().setLanguage("MYS").setRegion("MY").build();
        }else if(value.equals("VI")){
            return new Locale.Builder().setLanguage("vie").setRegion("MY").build();
        }else if(value.equals("TH")){
            return new Locale.Builder().setLanguage("THA").setRegion("TH").build();
        }

        return new Locale.Builder().setLanguage("en").setRegion("US").build();
    }
*/


    public static String message(String code, Locale locale, Object... args) {

        System.out.println("##################");
        System.out.println("##################"+ locale.getCountry());

        if (messageSource == null) {
            messageSource = SpringUtils.getBean(MessageSource.class);
        }


        return messageSource.getMessage(code, args, locale);
    }
}
