package com.lgy.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgy.common.utils.PageUtils;
import com.lgy.common.utils.Query;

import com.lgy.gulimall.product.dao.CategoryDao;
import com.lgy.gulimall.product.entity.CategoryEntity;
import com.lgy.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

//    @Autowired
//    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 自己编写的方法 ，要查出分类
     * 然后组装成父子的树形结构
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {

        //无查询条件，进行查询数据，所有的数据都查
        List<CategoryEntity> entities = baseMapper.selectList(null);

        List<CategoryEntity> level_1_Menus = entities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu)->{
            menu.setChildren(getChildrens(menu,entities));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort() == null? 0:menu1.getSort()- menu2.getSort());
        }).collect(Collectors.toList());
        // 组装成父子分类的树形结构

        return level_1_Menus;
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {

        //TODO 检查当前删除的菜单，是不是被引用
        //逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 找到categoryId 的完整路径
     * @param catelogId
     * @return
     */
    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> path = new ArrayList<>();

        List<Long> parentsPath = findParentsPath(catelogId, path);
        Collections.reverse(parentsPath);

        return parentsPath.toArray(new Long[parentsPath.size()]);
    }

    private List<Long> findParentsPath(Long catelogId,List<Long> paths){
        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0){
            findParentsPath(byId.getParentCid(),paths);
        }
        return paths;
    }

    /**
     * 递归查找当前菜单的子菜单
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //菜单的排序
            return (menu1.getSort() == null? 0:menu1.getSort()- menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}