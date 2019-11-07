package com.dubbo.dao;

import com.dubbo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * 生产者：用户持久层接口
 * @author zhoupeiwu
 * @Title: UserDao
 * @ProjectName demo
 * @Description: TODO
 * @date 2019-11-0115:11
 */
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User,Long> {

    List<User> findAllByIdCard(String idCard);
}
