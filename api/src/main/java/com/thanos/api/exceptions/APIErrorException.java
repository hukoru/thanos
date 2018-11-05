package com.thanos.api.exceptions;

import com.thanos.api.common.ErrorCode;

public class APIErrorException extends RuntimeException{

    private ErrorCode errorCode;
    public APIErrorException(ErrorCode errorMSG){
        this.errorCode = errorMSG;
    }

    public APIErrorException(ErrorCode errorMSG, Exception e){
        this.errorCode = errorMSG;
        super.initCause(e);
    }

    public String getErrorCode(){
        return this.errorCode.getCode();
    }

    public String getErrorMsg(){
        return this.errorCode.getMsg();
    }

    public ErrorCode getError(){ return this.errorCode; }

}
