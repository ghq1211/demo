package com.example.demo.system.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.system.dao.ResourceDao;
import com.example.demo.system.dao.RoleDao;
import com.example.demo.system.dao.RoleToResourceDao;
import com.example.demo.system.entity.Resource;
import com.example.demo.system.entity.Role;
import com.example.demo.system.entity.RoleToResource;
import com.example.demo.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/27 15:27
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleToResourceDao roleToResourceDao;

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public JSONObject info(Integer id) {
        JSONObject json = new JSONObject();
        Role role = roleDao.getOne(id);
        json.put("role",role);
        List<RoleToResource> list = roleToResourceDao.findByRole(role);
        List<Resource> roleToResourceList = new ArrayList<>();
        for (RoleToResource r : list){
            roleToResourceList.add(r.getResource());
        }
        json.put("roleToResourceList",roleToResourceList);
        List<Resource> resources = resourceDao.findAll();
        json.put("resources",resources);
        return json;
    }

    @Override
    @Transactional
    public void save(String name,Integer[] resources) {
        Role role = new Role();
        role.setName(name);
        if( resources != null && resources.length != 0){
            for (Integer resourceId : resources){
                Resource resource = resourceDao.getOne(resourceId);
                RoleToResource roleToResource = new RoleToResource();
                roleToResource.setRole(role);
                roleToResource.setResource(resource);
                roleToResourceDao.save(roleToResource);
            }
        }
        roleDao.save(role);
    }

    @Override
    public void update(Integer id,String name,Integer[] resources) {
        Role role = roleDao.getOne(id);
        role.setName(name);
        for (RoleToResource roleToResource : roleToResourceDao.findByRole(role)){
            roleToResourceDao.delete(roleToResource);
        }
        if( resources != null && resources.length != 0){
            for (Integer resourceId : resources){
                Resource resource = resourceDao.getOne(resourceId);
                RoleToResource roleToResource = new RoleToResource();
                roleToResource.setRole(role);
                roleToResource.setResource(resource);
                roleToResourceDao.save(roleToResource);
            }
        }
        roleDao.save(role);
    }

    @Override
    public void delete(Integer id) {
        Role role = roleDao.getOne(id);
        roleDao.delete(role);
    }

}
