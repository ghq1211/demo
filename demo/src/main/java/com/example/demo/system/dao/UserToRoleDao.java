package com.example.demo.system.dao;

import com.example.demo.system.entity.User;
import com.example.demo.system.entity.UserToRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:37
 * @Description:
 */
public interface UserToRoleDao extends JpaRepository<UserToRole,Integer>,JpaSpecificationExecutor<UserToRole> {

    UserToRole findByUser(User user);

}
