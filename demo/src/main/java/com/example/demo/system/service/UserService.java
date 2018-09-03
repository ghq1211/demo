package com.example.demo.system.service;

import com.example.demo.system.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:48
 * @Description:
 */
public interface UserService {

    Page<User> list(Integer page,Integer size);

    List<User> list();

    User info(Integer userId);

    void save(String username,String password);

    void update(Integer userId,String username,String password);

    void delete(Integer userId);

}
