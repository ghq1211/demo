package com.example.demo.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.config.StatusCode;
import com.example.demo.common.util.JsonResult;
import com.example.demo.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/27 15:26
 * @Description:
 */
@RestController
@RequestMapping(value = "/api")
@Api(value="角色controller",tags={"角色操作接口"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @GetMapping(value = "/v1/roles")
    @ApiOperation(value="获取角色列表", notes="")
    public JsonResult list(){
        return JsonResult.success(roleService.list());
    }

    @GetMapping(value = "/v1/roles/{id}")
    @ApiOperation(value="获取角色详细信息",notes="根据url的id来获取角色详细信息")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, dataType = "Integer")
    public JsonResult info(@PathVariable("id") Integer id){
        return JsonResult.success(roleService.info(id));
    }

    @ResponseBody
    @PostMapping(value = "/v1/roles")
    @ApiOperation(value="创建角色", notes="根据角色名称创建角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "角色名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "resources", value = "资源数组{id}", required = false, dataType = "Integer[]")
    })
    public JsonResult save(@RequestBody JSONObject json){
        String name = json.getString("name");
        String array = json.getString("resources");
        if (name == null || "".equals(name))
            return JsonResult.failure(StatusCode.CODE_REQUEST_PARAMETER,"角色名为空");
        Integer[] resources = null;
        if(array != null && array.length() != 0){
            String[] resStrArr = array.split(",");
            resources = new Integer[resStrArr.length];
            for (int i = 0 ;i < resStrArr.length ;i++){
                resources[i] = Integer.valueOf(resStrArr[i]);
            }
        }

        try {
            roleService.save(name,resources);
            return JsonResult.success("保存成功");
        }catch (Exception E){
            logger.error("",E);
            return JsonResult.failure("保存失败");
        }
    }

    @ResponseBody
    @PutMapping(value = "/v1/roles")
    @ApiOperation(value="更新角色信息", notes="根据id来指定更新对象，并根据传过来的角色名称来更新角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "角色名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "resources", value = "资源数组{id}", required = true, dataType = "Integer[]")
    })
    public JsonResult update(@RequestBody JSONObject json){
        String name = json.getString("name");
        String array = json.getString("resources");
        Integer id = json.getInteger("id");
        Integer[] resources = null;
        if(array != null && array.length() != 0){
            String[] resStrArr = array.split(",");
            resources = new Integer[resStrArr.length];
            for (int i = 0 ;i < resStrArr.length ;i++){
                resources[i] = Integer.valueOf(resStrArr[i]);
            }
        }
        try {
            roleService.update(id,name,resources);
            return JsonResult.success("保存成功");
        }catch (Exception E){
            logger.error("",E);
            return JsonResult.failure("保存失败");
        }
    }

    @ResponseBody
    @DeleteMapping(value = "/v1/roles/{id}")
    @ApiOperation(value="删除角色", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "Integer")
    public JsonResult delete(@PathVariable("id")Integer id){
        try {
            roleService.delete(id);
            return JsonResult.success("删除成功");
        }catch (Exception E){
            return JsonResult.failure("删除失败");
        }
    }




}
