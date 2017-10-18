package com.topplsky.pets.core.utils;

import com.topplsky.pets.common.constants.ErrorType;
import com.topplsky.pets.common.result.Result;
import com.topplsky.pets.core.context.ServiceContext;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.Map;

public class LoggerUtils {

    public static <T extends Result> T onLoginFailed(Logger logger, String methodTag, Map<String, Object> log, T result) {
        log.put("result", result);
        result.setSuccess(false);
        result.setErrorCode(ErrorType.LOGIN_TOKEN_INVALID.getErrorCode());
        result.setErrorMessage(ErrorType.LOGIN_TOKEN_INVALID.getErrorMessage());
        logger.error(methodTag + ".loginFailed, {}" + getLogString(log));
        return result;
    }

    public static <T extends Result> T onFinish(Logger logger, String methodTag, Map<String, Object> log, T result) {
        putSessionLog(log);
        log.put("result", result);
        logger.warn(methodTag + ".finish, {}", getLogString(log));
        return result;
    }

    public static <T extends Result> T onThrowable(Logger logger, Throwable t, String methodTag, Map<String, Object> log, T result) {
        putSessionLog(log);
        result.setSuccess(false);
        result.setErrorCode(ErrorType.SERVER_EXCEPTION.getErrorCode());
        while (t.getCause() != null && t.getCause() != t) {
            t = t.getCause();
        }
        logger.error(methodTag + ".unknownError, {}", getLogString(log), t);
        return result;
    }

    private static void putSessionLog(Map<String, Object> log) {
        if (ServiceContext.containsKey(ServiceContext.REQUESTED_API)) {
            log.put("requestedAPI", ServiceContext.get(ServiceContext.REQUESTED_API));
        }
        if (ServiceContext.containsKey(ServiceContext.USER_ID)) {
            log.put("userId", ServiceContext.get(ServiceContext.USER_ID));
        }
        if (ServiceContext.containsKey(ServiceContext.LOGIN_TOKEN)) {
            log.put("loginToken", ServiceContext.get(ServiceContext.LOGIN_TOKEN));
        }
    }

    private static String getLogString(Map<String, Object> log) {
        StringBuilder builder = new StringBuilder("{");
        String sp = "";
        for (Map.Entry<String, Object> entry : log.entrySet()) {
            builder.append(sp);
            if (entry.getValue() instanceof Collection) {
                builder.append(entry.getKey()).append("=").append(((Collection) entry.getValue()).size());
            } else if (entry.getValue() instanceof Map) {
                builder.append(entry.getKey()).append("=").append(((Map) entry.getValue()).size());
            } else {
                builder.append(entry.getKey()).append("=").append(entry.getValue());
            }
            sp = ",";
        }
        builder.append("}");
        return builder.toString();
    }
}
