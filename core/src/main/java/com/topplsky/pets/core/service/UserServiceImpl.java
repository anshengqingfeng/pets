package com.topplsky.pets.core.service;

import com.google.common.collect.Maps;
import com.topplsky.pets.client.service.UserService;
import com.topplsky.pets.common.request.UserUpdateRequest;
import com.topplsky.pets.common.result.Result;
import com.topplsky.pets.common.result.UserDTO;
import com.topplsky.pets.dal.domain.UserDO;
import com.topplsky.pets.dal.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<UserDTO> getUserById(int id) {
        String methodTag = "UserServiceImpl.getUserById";
        Map<String, Object> log = Maps.newHashMap();
        log.put("id", id);
        Result<UserDTO> result = Result._new();
        try {
            UserDO userDO = userMapper.getUserById(id);
            result.setData(convertToUserDTO(userDO));
            return onFinish(methodTag, log, result);
        } catch (Throwable throwable) {
            return onThrowable(throwable, methodTag, log, result);
        }
    }

    @Override
    public Result<Boolean> updateUser(UserUpdateRequest request) {
        String methodTag = "UserServiceImpl.updateUser";
        Map<String, Object> log = Maps.newHashMap();
        log.put("request", request);
        Result<Boolean> result = Result._new();
        try {
            int i = userMapper.updateUser(convertFromRequest(request));
            result.setData(i > 0);
            return onFinish(methodTag, log, result);
        } catch (Throwable throwable) {
            return onThrowable(throwable, methodTag, log, result);
        }
    }

    @Override
    public Result<Boolean> addUser(UserUpdateRequest request) {
        String methodTag = "UserServiceImpl.addUser";
        Map<String, Object> log = Maps.newHashMap();
        log.put("request", request);
        Result<Boolean> result = Result._new();
        try {
            int i = userMapper.addUser(convertFromRequest(request));
            result.setData(i > 0);
            return onFinish(methodTag, log, result);
        } catch (Throwable throwable) {
            return onThrowable(throwable, methodTag, log, result);
        }
    }

    private UserDTO convertToUserDTO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        if (userDO == null) {
            return userDTO;
        }
        userDTO = new UserDTO();
        userDTO.setId(userDO.getId());
        userDTO.setUsername(userDO.getUsername());
        userDTO.setPassword(userDO.getPassword());
        userDTO.setEmail(userDO.getEmail());
        userDTO.setPhone(userDO.getPhone());
        userDTO.setPid(userDO.getPid());
        return userDTO;
    }

    private UserDO convertFromRequest(UserUpdateRequest request) {
        UserDO userDO = new UserDO();
        if (request == null) {
            return userDO;
        }
        userDO.setId(request.getId());
        userDO.setUsername(request.getUsername());
        userDO.setPassword(request.getPassword());
        userDO.setEmail(request.getEmail());
        userDO.setPhone(request.getPhone());
        userDO.setPid(request.getPid());
        return userDO;
    }

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Logger getLogger() {
        return logger;
    }

}
