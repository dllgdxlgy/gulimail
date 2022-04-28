package com.lgy.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 整合 mybaties-plus
 * 1. 导入依赖
 *
 * 2.配置
 * 	1.配置数据源
 * 		1） 导入数据库的驱动
 * 		2）在 application 里面配置数据源
 * 	2. 配置Mybaties - Plus
 * 		1)使用 Mapper-Scan
 * 		2）告诉mybaties -plus，sql 映射文件在哪
 */
@EnableDiscoveryClient
@MapperScan("com.lgy.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
