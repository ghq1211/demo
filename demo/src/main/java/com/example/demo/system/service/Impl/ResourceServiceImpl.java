package com.example.demo.system.service.Impl;

import com.example.demo.system.dao.ResourceDao;
import com.example.demo.system.entity.Resource;
import com.example.demo.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/27 16:45
 * @Description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> list() {
        return resourceDao.findAll();
    }

    @Override
    public Resource info(Integer id) {
        return resourceDao.getOne(id);
    }

    @Override
    public void save(String name,String descritpion,String url,Integer pid,String method) {
        Resource resource = new Resource();
        resource.setName(name);
        resource.setDescritpion(descritpion);
        resource.setUrl(url);
        resource.setPid(pid);
        resource.setMethod(method);
        resourceDao.save(resource);
    }

    @Override
    public void update(Integer id, String name,String descritpion,String url,Integer pid,String method) {
        Resource resource = resourceDao.getOne(id);
        resource.setName(name);
        resource.setDescritpion(descritpion);
        resource.setUrl(url);
        resource.setPid(pid);
        resource.setMethod(method);
        resourceDao.save(resource);
    }

    @Override
    public void delete(Integer id) {
        Resource resource = resourceDao.getOne(id);
        resourceDao.delete(resource);
    }
}
