package com.example.demo.system.controller;

import com.example.demo.common.util.JsonResult;
import com.example.demo.system.service.UserService;
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
 * @Date: 2018/7/26 17:51
 * @Description:
 */
@RestController
@RequestMapping(value = "/api")
@Api(value="用户controller",tags={"用户操作接口"})
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @GetMapping(value = "/v1/users")
    @ApiOperation(value="获取用户列表", notes="")
    public JsonResult list(){
        logger.info("请求用户列表");
        return JsonResult.success(userService.list());
    }

    @ResponseBody
    @GetMapping(value = "/v1/users/{id}")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer")
    public JsonResult info(@PathVariable("id") Integer userId){
        return JsonResult.success(userService.info(userId));
    }

    @ResponseBody
    @PostMapping(value = "/v1/users")
    @ApiOperation(value="创建用户", notes="根据用户名和密码创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    public JsonResult save(@RequestParam("username")String userName,
                           @RequestParam("password")String password){
        try {
            userService.save(userName,password);
            return JsonResult.success("保存成功");
        }catch (Exception E){
            return JsonResult.failure("保存失败");
        }
    }

    @ResponseBody
    @PutMapping(value = "/v1/users")
    @ApiOperation(value="更新用户详细信息", notes="根据id来指定更新对象，并根据传过来的用户名和密码来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    public JsonResult update(@RequestParam("id")Integer id,
                             @RequestParam("username")String userName,
                             @RequestParam("password")String password){
        try {
            userService.update(id,userName,password);
            return JsonResult.success("保存成功");
        }catch (Exception E){
            return JsonResult.failure("保存失败");
        }
    }

    @ResponseBody
    @DeleteMapping(value = "/v1/users/{id}")
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    public JsonResult delete(@PathVariable("id")Integer id){
        try {
            userService.delete(id);
            return JsonResult.success("删除成功");
        }catch (Exception E){
            return JsonResult.failure("删除失败");
        }
    }


}
