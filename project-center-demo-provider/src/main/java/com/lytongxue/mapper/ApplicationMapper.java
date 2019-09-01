package com.lytongxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lytongxue.domain.entity.ApplicationDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationMapper extends BaseMapper<ApplicationDO> {
}
