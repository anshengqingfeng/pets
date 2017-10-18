package com.topplsky.pets.client.service;

import com.topplsky.pets.common.request.UserUpdateRequest;
import com.topplsky.pets.common.result.Result;
import com.topplsky.pets.common.result.UserDTO;

public interface UserService extends BaseService {

    Result<UserDTO> getUserById(int id);

    Result<Boolean> updateUser(UserUpdateRequest request);

    Result<Boolean> addUser(UserUpdateRequest request);
}
