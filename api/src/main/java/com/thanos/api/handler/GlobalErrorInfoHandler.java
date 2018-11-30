package com.thanos.api.handler;

import com.thanos.api.common.MessageUtils;
import com.thanos.api.common.constant.GlobalErrorInfoEnum;
import com.thanos.api.exceptions.GlobalErrorInfoException;
import com.thanos.api.result.ErrorInfo;
import com.thanos.api.result.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestControllerAdvice
public class GlobalErrorInfoHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalErrorInfoHandler.class);



    @ExceptionHandler(value = RuntimeException.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest request, RuntimeException exception) {

        ResultBody result = new ResultBody(GlobalErrorInfoEnum.PARAM_NOT_NULL);
        return result;
    }



    @ExceptionHandler(value = GlobalErrorInfoException.class)
    public ResultBody handleGlobalErrorInfoException(HttpServletRequest request, Locale locale, GlobalErrorInfoException exception) {
        ErrorInfo errorInfo = exception.getErrorInfo();

        System.out.println("@@@@@ " + errorInfo.getMessage());

        getMessage(errorInfo, locale, exception.getArgs());

        ResultBody result = new ResultBody(errorInfo);
        return result;
    }

    private void getMessage(ErrorInfo errorInfo, Locale locale, Object... args) {
        String message = null;


        if (!StringUtils.isEmpty(errorInfo.getCode())) {
            message = MessageUtils.message(errorInfo.getCode(), locale, args);
        }
        if (message == null) {
            message = errorInfo.getMessage();
        }
        errorInfo.setMessage(message);
    }
}
