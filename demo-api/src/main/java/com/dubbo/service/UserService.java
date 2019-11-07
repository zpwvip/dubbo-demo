package com.dubbo.service;

import com.dubbo.entity.User;

import java.util.List;

/**
 * @author zhoupeiwu
 * @Title: UserService
 * @ProjectName demo
 * @Description: TODO
 * @date 2019-10-3120:42
 */
public interface UserService {

    public List<User> findAllByIdCard(String idCard);
}
