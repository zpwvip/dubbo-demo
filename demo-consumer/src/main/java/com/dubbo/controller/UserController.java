package com.dubbo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.entity.User;
import com.dubbo.utils.Result;
import jdk.nashorn.internal.ir.annotations.Reference;
import com.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhoupeiwu
 * @Title: UserController
 * @ProjectName demo
 * @Description: TODO
 * @date 2019-10-3120:57
 */
@Slf4j
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 根据身份证号查询用户
     * @param jsonData
     * @return
     */
    @RequestMapping(value = "findAllByIdCard")
    public Result findAllByIdCard(@RequestBody String jsonData){
        Result result = new Result(-1,"处理中");
        try{
            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            String idCard = jsonObject.getString("idCard");
            if(StringUtils.isNotEmpty(idCard)){
                List<User> userList = userService.findAllByIdCard(idCard);
                result = new Result(userList);
            }else{
                result = new Result(-1,"身份证不允许为空！");
            }
        }catch (Exception ex){
            log.info("根据身份证号查询用户出现异常:"+ex);
            result = new Result(-1,"根据身份证号查询用户出现异常");
        }
        return result;
    }
}
