package com.lgy.gulimall.product.Vo;

import lombok.Data;

@Data
public class AttrRespVo extends AttrVo{

    /**
     * 分类的名字
     */
    private String catelogName;

    private String groupName;


    private Long[] catelogPath;

}
