package com.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhoupeiwu
 * @Title: DemoConsumerApplication
 * @ProjectName demo
 * @Description: TODO
 * @date 2019-11-0510:21
 */

@EnableDubbo
@SpringBootApplication
public class DemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApplication.class,args);
    }
}
