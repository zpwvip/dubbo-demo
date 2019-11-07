package com.dubbo.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import com.dubbo.service.UserService;

/**
 * @author zhoupeiwu
 * @Title: UserController
 * @ProjectName demo
 * @Description: TODO
 * @date 2019-10-3120:57
 */
public class UserController {

    @Reference
    private UserService userService;
}
