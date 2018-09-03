package com.example.demo.system.service;


import com.example.demo.system.entity.Resource;

import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/27 16:44
 * @Description:
 */
public interface ResourceService {

    List<Resource> list();

    Resource info(Integer id);

    void save(String name,String descritpion,String url,Integer pid,String method);

    void update(Integer id,String name,String descritpion,String url,Integer pid,String method);

    void delete(Integer id);

}
