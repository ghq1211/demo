package com.example.demo.system.controller;

import com.example.demo.common.util.JsonResult;
import com.example.demo.system.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value="资源controller",tags={"资源操作接口"})
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ResponseBody
    @GetMapping(value = "/v1/resource")
    @ApiOperation(value="获取资源列表", notes="")
    public JsonResult list(){
        return JsonResult.success(resourceService.list());
    }

    @GetMapping(value = "/v1/resource/{id}")
    @ApiOperation(value="获取资源详细信息",notes="根据url的id来获取资源详细信息")
    @ApiImplicitParam(name = "resourceId", value = "资源ID", required = true, dataType = "Integer")
    public JsonResult info(@PathVariable("id") Integer id){
        return JsonResult.success(resourceService.info(id));
    }

    @ResponseBody
    @PostMapping(value = "/v1/resource")
    @ApiOperation(value="创建资源", notes="根据资源名称创建资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "资源名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "descritpion", value = "资源描述", required = true, dataType = "String"),
            @ApiImplicitParam(name = "url", value = "资源url", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pid", value = "资源父id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "method", value = "请求方式", required = true, dataType = "String"),
    })
    public JsonResult save(@RequestParam("name")String name,
                           @RequestParam("descritpion")String descritpion,
                           @RequestParam("url")String url,
                           @RequestParam("pid")Integer pid,
                           @RequestParam("method")String method){
        try {
            resourceService.save(name,descritpion,url,pid,method);
            return JsonResult.success("保存成功");
        }catch (Exception E){
            return JsonResult.failure("保存失败");
        }
    }

    @ResponseBody
    @PutMapping(value = "/v1/resource")
    @ApiOperation(value="更新资源信息", notes="根据id来指定更新对象，并根据传过来的资源名称来更新资源信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "资源名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "descritpion", value = "资源描述", required = true, dataType = "String"),
            @ApiImplicitParam(name = "url", value = "资源url", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pid", value = "资源父id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "method", value = "请求方式", required = true, dataType = "String"),
    })
    public JsonResult update(@RequestParam("id")Integer id,
                             @RequestParam("name")String name,
                             @RequestParam("descritpion")String descritpion,
                             @RequestParam("url")String url,
                             @RequestParam("pid")Integer pid,
                             @RequestParam("method")String method){
        try {
            resourceService.update(id,name,descritpion,url,pid,method);
            return JsonResult.success("保存成功");
        }catch (Exception E){
            return JsonResult.failure("保存失败");
        }
    }

    @ResponseBody
    @DeleteMapping(value = "/v1/resource/{id}")
    @ApiOperation(value="删除资源", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "资源ID", required = true, dataType = "Integer")
    public JsonResult delete(@PathVariable("id")Integer id){
        try {
            resourceService.delete(id);
            return JsonResult.success("删除成功");
        }catch (Exception E){
            return JsonResult.failure("删除失败");
        }
    }



}
