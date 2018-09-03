package com.example.demo.system.entity;

import javax.persistence.*;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/26 17:16
 * @Description: 角色表
 */

@Entity
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
