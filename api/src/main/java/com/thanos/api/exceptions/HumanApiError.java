package com.thanos.api.exceptions;

/**
 * 사용자 에러
 * 유저가 내는 에러로 유저는 사람만을 의미하지 않으면 API 시스템을 사용하는 모두가 해당된다. API call 자체를 잘못 날리는 경우 해당 에러코드를 이용한다.
 */
public enum HumanApiError implements Error {

    INVALID_ARGS("H001", "입력값이 잘못되었습니다"),
    EXPIRED("H002", "만료 되었습니다"),
    IS_EMPTY("H003", "존재하지 않는 데이터입니다"),
    NO_SUPPORT("H004", "지원이 불가능합니다"),
    NOT_FOUND("H005", "API가 존재하지 않습니다"),
    FAIL_BIND("H006", "요청에 대한 파라미터 바인딩에 실패하였습니다"),
    INTERNAL_ERROR("H010", "시스템 내부적으로 오류가 발생하였습니다.");

    private final String code;
    private final String message;

    HumanApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
