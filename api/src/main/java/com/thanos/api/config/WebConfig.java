package com.thanos.api.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * All the web app configuration happens here
 *
 * @author LanyonM
 */
@Configuration
@ComponentScan("com.thanos.api.controller")
public class WebConfig extends WebMvcConfigurerAdapter {


    /*
     * Configure ContentNegotiationManager
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true);
        Charset charset = Charset.forName("UTF-8");
        MediaType mediaType = new MediaType("application", "json", charset);
        configurer.defaultContentType(mediaType);

    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
        //request로 넘어오는 language parameter를 받아서 locale로 설정 한다.
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver sessionLocaleResolver(){
        //세션 기준으로 로케일을 설정 한다.
        SessionLocaleResolver localeResolver=new SessionLocaleResolver();
        //쿠키 기준(세션이 끊겨도 브라우져에 설정된 쿠키 기준으로)
//        CookieLocaleResolver localeResolver = new CookieLocaleResolver();

        //최초 기본 로케일을 강제로 설정이 가능 하다.
        localeResolver.setDefaultLocale(new Locale("en_US"));
        return localeResolver;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }



}
