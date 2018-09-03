package com.example.demo.system.service.Impl;

import com.example.demo.system.dao.UserDao;
import com.example.demo.system.entity.User;
import com.example.demo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:49
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Page<User> list(Integer page,Integer size) {
        Pageable pageable = new PageRequest(page,size);
        Page<User> pages = userDao.findAll(pageable);
        return pages;
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public User info(Integer userId) {
        return userDao.getOne(userId);
    }

    @Override
    public void save(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void update(Integer userId, String username, String password) {
        User user = userDao.getOne(userId);
        user.setUsername(username);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void delete(Integer userId) {
        User user = userDao.getOne(userId);
        userDao.delete(user);
    }


}
