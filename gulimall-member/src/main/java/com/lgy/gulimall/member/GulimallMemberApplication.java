package com.lgy.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 想要远程调用别的服务，
 * 1. 就要引入 open-fenign 这个包
 * 2. 编写一个接口，告诉SpringCloud这个接口调用远程服务
 * 		1. 声明接口的每一个方法都是调用哪个远程服务的那个请求
 * 		2. 开启远程调用功能
 */
@EnableFeignClients(basePackages = "com.lgy.gulimall.member.feign") //自动扫描该包下标有@FeignClient注解的接口
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallMemberApplication.class, args);
	}

}
