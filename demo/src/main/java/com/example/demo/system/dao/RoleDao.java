package com.example.demo.system.dao;


import com.example.demo.system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:35
 * @Description:
 */
public interface RoleDao extends JpaRepository<Role,Integer>,JpaSpecificationExecutor<Role> {
}
