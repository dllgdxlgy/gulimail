package com.lgy.gulimall.product;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgy.gulimall.product.entity.BrandEntity;
import com.lgy.gulimall.product.service.BrandService;

import com.lgy.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@Slf4j
@SpringBootTest
class GulimallProductApplicationTests {


	@Autowired
	private BrandService brandService;

	@Autowired
	private CategoryService categoryService;

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

	@Test
	public void testFindPath(){
		Long[] catelogPath = categoryService.findCatelogPath(225L);
		log.info("完整路径：{}", Arrays.asList(catelogPath));
	}



}
