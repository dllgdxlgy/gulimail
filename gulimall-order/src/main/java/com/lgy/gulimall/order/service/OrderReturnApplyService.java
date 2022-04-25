package com.lgy.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgy.common.utils.PageUtils;
import com.lgy.gulimall.order.entity.OrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 17:23:00
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

