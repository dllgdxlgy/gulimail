package com.lgy.gulimall.member.dao;

import com.lgy.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 16:52:04
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
