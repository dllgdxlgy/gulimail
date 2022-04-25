package com.lgy.gulimall.product.dao;

import com.lgy.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 14:40:06
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
