package com.lgy.gulimall.product.service.impl;

import com.lgy.gulimall.product.service.CategoryBrandRelationService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgy.common.utils.PageUtils;
import com.lgy.common.utils.Query;

import com.lgy.gulimall.product.dao.BrandDao;
import com.lgy.gulimall.product.entity.BrandEntity;
import com.lgy.gulimall.product.service.BrandService;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String key = (String)params.get("key");
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)){
            wrapper.eq("brand_id",key).or().like("name",key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);

    }

    /**
     * 不仅要更新品牌表，还要更新与分类表关联的表
     * @param brand
     */
    @Override
    public void updateDetail(BrandEntity brand) {
        //保证冗余字段的数据是正确的
        this.updateById(brand);
        //再来判断
        if(!StringUtils.isEmpty(brand.getName())){
            //
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
            //TODO 更新其他关联
        }

    }

}