package com.thanos.api.result;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class ApiResponse<T> {

    private static final String successCode = "0000";
    private static final String successMsg = "OK";

    private final String code;        //상태
    private final String message;     //메시지
    private final T result;

    public ApiResponse(T t) {
        this.code = successCode;
        this.message = successMsg;
        this.result = t;
    }

    private ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.result = null;
    }

    private ApiResponse(ErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
        this.result = null;
    }


    public static ApiResponse success() {
        return new ApiResponse(successCode, successMsg);
    }

    public static ApiResponse fail(ErrorInfo errorInfo) {
        return new ApiResponse(errorInfo);
    }

    public static ApiResponse fail(String code, String message) {
        return new ApiResponse(code, message);
    }
}

