package com.lgy.gulimall.order.dao;

import com.lgy.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 17:23:00
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
