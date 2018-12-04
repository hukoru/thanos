package com.thanos.api.exceptions;


import lombok.Getter;

/**
 * 어플리케이션에서 사용 할 Exception
 */
public class ThanosException extends RuntimeException {

    @Getter
    private String code;
    @Getter
    private String msg;
    @Getter
    private String loggingMsg;
    @Getter
    private Throwable throwable;

    public ThanosException(Error error) {
        super(String.format("[%s] %s", error.code(), error.message()));

        bindParams(error, error.message());
    }

    public ThanosException(Error error, String errMsg) {
        super(String.format("[%s] %s", error.code(), errMsg));

        bindParams(error, errMsg);
    }

    public ThanosException(Error error, String errMsg, String loggingMsg) {
        super(String.format("[%s] %s", error.code(), errMsg));
        bindParams(error, errMsg);
        this.loggingMsg = "logging msg: " + loggingMsg;
    }

    //TODO 5dolstory: 이거 실용적인지 테스트가 필요함. (throwable 로그도 잘 나오는지 봐야 할듯.)
    public ThanosException(Error error, String errMsg, Throwable throwable, String loggingMsg) {
        super(String.format("[%s] %s | %s", error.code(), errMsg, loggingMsg));
        bindParams(error, errMsg);
        this.loggingMsg = String.format("throwable: %s, logging msg: %s", throwable.getMessage(), loggingMsg);
        this.throwable = throwable;
    }

    private void bindParams(Error error, String errMsg) {
        this.code = error.code();
        this.msg = errMsg;
    }


}
