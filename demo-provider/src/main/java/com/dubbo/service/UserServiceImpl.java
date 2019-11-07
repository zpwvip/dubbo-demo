package com.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.dao.UserDao;
import com.dubbo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhoupeiwu
 * @Title: UserServiceImpl
 * @ProjectName demo
 * @Description: TODO
 * @date 2019-10-3120:58
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据身份证号查询用户列表
     *
     * @param idCard
     * @return
     */
    public List<User> findAllByIdCard(String idCard) {
        return userDao.findAllByIdCard(idCard);
    }
}
