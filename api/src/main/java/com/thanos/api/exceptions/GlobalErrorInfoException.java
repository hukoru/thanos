package com.thanos.api.exceptions;

import com.thanos.api.result.ErrorInfo;


public class GlobalErrorInfoException extends Exception {

    private ErrorInfo errorInfo;

    private Object[] args;

    public GlobalErrorInfoException(ErrorInfo errorInfo) {

        this.errorInfo = errorInfo;
    }

    public GlobalErrorInfoException(ErrorInfo errorInfo, Object... args) {

        this.errorInfo = errorInfo;
        this.args = args;
    }


    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
