package com.topplsky.pets.dal.mapper;

import com.topplsky.pets.dal.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDO getUserById(int id);

    int updateUser(UserDO userDO);

    int addUser(UserDO userDO);
}
