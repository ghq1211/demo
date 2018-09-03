package com.example.demo.system.dao;

import com.example.demo.system.entity.Resource;
import com.example.demo.system.entity.Role;
import com.example.demo.system.entity.RoleToResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:38
 * @Description:
 */
public interface RoleToResourceDao extends JpaRepository<RoleToResource,Integer>,JpaSpecificationExecutor<RoleToResource> {

    /**
     * @Author: 郭慧乔
     * @Date: 8:31 2018/7/30
     * @Description: 根据角色查询对应的资源
     * @修改者:
     * @修改时间:
     * @修改内容:
     */
    List<RoleToResource> findByRole(Role role);

    RoleToResource findByRoleAndResource(Role role, Resource resource);

    void deleteByRole(Role role);

}
