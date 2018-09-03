package com.example.demo.system.dao;

import com.example.demo.system.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:36
 * @Description:
 */
public interface ResourceDao extends JpaRepository<Resource,Integer>,JpaSpecificationExecutor<Resource> {
}
