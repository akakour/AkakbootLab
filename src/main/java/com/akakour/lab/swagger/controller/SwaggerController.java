package com.akakour.lab.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Api的主分类
@Api(tags = "SpringBoot 整合 Swagger2，这是一个Controller接口测试")
public class SwaggerController {

    @Data
    public class User {
        String name;
        String city;

    }

    @PostMapping("/getUserById/{id}")
    //Api的动作描述
    @ApiOperation("查询个人信息")
    //Api的参数信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "个人ID")
    })
    public User getUserById(@PathVariable("id") String id) {
        User user = new User();
        user.setName("akakour");
        user.setCity("ToKyo Shinagawa");
        return user;
    }
}
