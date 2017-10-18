package com.topplsky.pets.core.service;

import com.topplsky.pets.client.service.BaseService;
import com.topplsky.pets.common.result.Result;
import com.topplsky.pets.core.utils.LoggerUtils;
import org.slf4j.Logger;

import java.util.Map;

public abstract class BaseServiceImpl implements BaseService {

    public <T extends Result> T onLoginFailed(Logger logger, String methodTag, Map<String, Object> log, T result) {
        return LoggerUtils.onLoginFailed(logger, methodTag, log, result);
    }

    public <T extends Result> T onFinish(String methodTag, Map<String, Object> log, T result) {
        return LoggerUtils.onFinish(getLogger(), methodTag, log, result);
    }

    public <T extends Result> T onThrowable(Throwable t, String methodTag, Map<String, Object> log, T result) {
        return LoggerUtils.onThrowable(getLogger(), t, methodTag, log, result);
    }
}
