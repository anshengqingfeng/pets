package com.topplsky.pets.client.service;

import com.topplsky.pets.common.result.Result;
import org.slf4j.Logger;

import java.util.Map;

public interface BaseService {
    Logger getLogger();

    <T extends Result> T onLoginFailed(Logger logger, String methodTag, Map<String, Object> log, T result);

    <T extends Result> T onFinish(String methodTag, Map<String, Object> log, T result);

    <T extends Result> T onThrowable(Throwable throwable, String methodTag, Map<String, Object> log, T result);
}
