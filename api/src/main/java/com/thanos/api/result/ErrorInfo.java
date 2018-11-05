package com.thanos.api.result;


public interface ErrorInfo {

    String getCode();

    String getMessage();

    void setMessage(String message);

}
