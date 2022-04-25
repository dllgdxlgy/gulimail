package com.lgy.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgy.common.utils.PageUtils;
import com.lgy.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 14:40:06
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

