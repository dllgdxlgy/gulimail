package com.lgy.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 如何使用 Nacos 作为配置中心统一管理配置
 * 1. 引入依赖
 * 2. 创建一个bootstrap.properties文件，配置好应用的名字和Nacos 的地址
 * 3. 需要给配置中心默认添加一个当前应用名+properties 的dataId
 * 4. 给我们的应用添加应有的配置
 * 5. 结合 @RefreshScope 注解 和 @Value("${coupon.user.name}")) 获取某一个配置的值，可以动态获取并刷新配置。
 *
 * 如果配置中心和当前配置文件都存在同一个配置，优先使用配置中心的配置
 *
 * 1. 细节
 * 1.1 命名空间 用来做配置隔离的
 * 		1. 开发、测试、生产、利用命名空间来做环境隔离
 *		默认：public(保留空间)默认新增的配置全部在 public 空间下
 *	注意：在 bootstrap.properties 配置上，需要使用哪一个命名空间的配置
 *	spring.cloud.nacos.config.namespace=150de77b-839b-4ff8-961e-d151e251a0d7
 *		2. 微服务众多，每一个微服务创建自己的命名空间，只加载自己命名空间下的配置
 *
 * 1.2 配置集
 * 	一组相关的配置集合
 * 1.3 配置集 ID
 * 	类似于文件名  Data ID
 * 1.4 配置分组（重要）
 * 	默认所有的配置集都属于 DEFAULT_GROUP
 *
 * 	该项目中是这样使用的：
 * 	每个微服务创建自己的命名空间，使用配置分组区分环境。 dev\test\prod
 *
 */



// 开启服务的注册，注册到注册中心
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallCouponApplication.class, args);
	}

}
