package com.topplsky.pets.web.api;

import com.topplsky.pets.client.service.UserService;
import com.topplsky.pets.common.request.UserUpdateRequest;
import com.topplsky.pets.common.result.Result;
import com.topplsky.pets.common.result.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/userInfo/{id}")
    public Result<UserDTO> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/userInfo/{id}")
    public Result<Boolean> getUserById(@PathVariable("id") Integer id, @RequestBody UserUpdateRequest request) {
        request.setId(id);
        return userService.updateUser(request);
    }

    @PostMapping("/userInfo/add")
    public Result<Boolean> addUser(@RequestBody UserUpdateRequest request) {
        return userService.addUser(request);
    }
}
