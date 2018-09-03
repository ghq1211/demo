package com.example.demo.system.dao;

import com.example.demo.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:34
 * @Description:
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

    User findByUsername(String username);


}
