package com.lgy.gulimall.product;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgy.gulimall.product.entity.BrandEntity;
import com.lgy.gulimall.product.service.BrandService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class GulimallProductApplicationTests {


	@Autowired
	private BrandService brandService;

	@Test
	public void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setDescript("这是商品的描述2");
//		brandEntity.setName("品牌的名字2");
//		brandService.save(brandEntity);
//		System.out.println("保存成功...");

		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 2L));
		list.forEach((item)->{
			System.out.println(item);
		});
	}



}
