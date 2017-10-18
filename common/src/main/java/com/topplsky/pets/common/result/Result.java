package com.topplsky.pets.common.result;

import com.topplsky.pets.common.BaseBean;

import java.util.Collection;
import java.util.Map;

public class Result<T> extends BaseBean {
    private static final long serialVersionUID = -8150281345999950130L;
    private String errorCode;
    private String errorMessage;
    private boolean success = true;
    private T data;

    public static <T> Result<T> _new() {
        return new Result<>();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String dataStr = "";
        if (data instanceof Collection) {
            dataStr += ((Collection) data).size();
        } else if (data instanceof Map) {
            dataStr += ((Map) data).size();
        } else {
            dataStr += data;
        }
        return "Result{" +
                "success=" + success +
                ", data=" + dataStr +
                ", errorCode=" + errorCode +
                ", errorMessage=" + errorMessage +
                '}';
    }
}
