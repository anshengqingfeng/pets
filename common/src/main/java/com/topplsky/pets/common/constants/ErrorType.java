package com.topplsky.pets.common.constants;

public enum ErrorType {

    LOGIN_TOKEN_INVALID("LOGIN_TOKEN_INVALID", "请检查登陆状态"),
    SERVER_EXCEPTION("SERVER_EXCEPTION", "系统繁忙，请稍后再试"),;

    private String errorCode;
    private String errorMessage;

    ErrorType(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return errorCode + "," + errorMessage;
    }

}
