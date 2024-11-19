package org.csu.soaex2.controller;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import org.springframework.context.ApplicationContext;
import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    public List<Link> getAllLink(){

        Link Link1= Link.of("http://localhost:8080/users").withRel("POST:创建用户");

        Link Link2= Link.of("http://localhost:8080/users/{user_id}").withRel("GET:查询指定用户信息");

        Link Link3= Link.of("http://localhost:8080/users/{user_id}").withRel("DELETE:删除指定用户信息");

        Link Link4= Link.of("http://localhost:8080/users").withRel("GET:查询所有用户信息");

        Link Link5= Link.of("http://localhost:8080/users/{user_id}").withRel("PUT:更新指定用户信息");


        return List.of(Link1,Link2,Link3,Link4,Link5);

    }

    @PostMapping
    public CommonResponse createOneUser(@RequestBody Map map){

        CommonResponse commonResponse=userInfoService.createOneUser(map);

        commonResponse.addLinks(getAllLink());
        return commonResponse;

    }

    @GetMapping("/{user_id}")
    public CommonResponse searchOneUser(@PathVariable("user_id") String user_id){

        CommonResponse commonResponse=userInfoService.searchOneUser(user_id);
        commonResponse.addLinks(getAllLink());
        return commonResponse;
    }
    @DeleteMapping("/{user_id}")
    public CommonResponse deleteOneUser(@PathVariable("user_id") String user_id){
        CommonResponse commonResponse=userInfoService.deleteOneUser(user_id);
        commonResponse.addLinks(getAllLink());
        return commonResponse;
    }

    @GetMapping
    public CommonResponse getAllUser(){
        CommonResponse commonResponse=userInfoService.getAllUser();
        commonResponse.addLinks(getAllLink());
        return commonResponse;
    }

    @PutMapping("/{user_id}")
    public CommonResponse updateOneUser(@RequestBody Map map, @PathVariable("user_id") String user_id){
        CommonResponse commonResponse=userInfoService.updateOneUser(map,user_id);
        commonResponse.addLinks(getAllLink());
        return commonResponse;
    }





}
