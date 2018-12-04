package com.thanos.api.result;

import com.thanos.api.common.constant.GlobalErrorInfoEnum;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Optional;

@Getter
@ToString
public class ResultBody  {

    private static final String successCode = "0000";
    private static final String successMsg = "OK";


    private final String serverCode;
    private final String serverMessage;
    private final Object results;


    public ResultBody(ErrorInfo errorInfo) {
        this.serverCode = errorInfo.getCode();
        this.serverMessage = errorInfo.getMessage();
        this.results = null;
    }

    public ResultBody() {
        this.serverCode = successCode;
        this.serverMessage = successMsg;
        this.results = null;
    }

    public ResultBody(Object results) {
        this.serverCode = GlobalErrorInfoEnum.SUCCESS.getCode();
        this.serverMessage = GlobalErrorInfoEnum.SUCCESS.getMessage();
        this.results = results;
    }


}
