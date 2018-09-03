package com.example.demo.system.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.system.entity.Role;

import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/27 15:26
 * @Description:
 */
public interface RoleService {

    List<Role> list();

    JSONObject info(Integer id);

    void save(String name,Integer[] resources);

    void update(Integer id,String name,Integer[] resources);

    void delete(Integer id);

}
