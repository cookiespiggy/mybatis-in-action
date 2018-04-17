package com.imooc.mapper;

import com.imooc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(Long id);

    User queryUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    void saveUser(User user);

    void updateUser(User user);

    void deleteById(Long id);

}
