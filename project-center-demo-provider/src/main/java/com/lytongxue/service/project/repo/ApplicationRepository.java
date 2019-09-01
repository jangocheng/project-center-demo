package com.lytongxue.service.project.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lytongxue.domain.entity.ApplicationDO;
import com.lytongxue.mapper.ApplicationMapper;
import com.lytongxue.service.project.manager.ApplicationManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationRepository {

    @Autowired
    private ApplicationMapper mapper;

    public Integer create(ApplicationDO entity) {
        return mapper.insert(entity);
    }

    public ApplicationDO selectById(String id) {
        return mapper.selectById(id);
    }

    public List<ApplicationDO> selectList(ApplicationManager.Query query) {
        return selectPage(query).getRecords();
    }

    public Page<ApplicationDO> selectPage(ApplicationManager.Query query) {
        Page<ApplicationDO> page = new Page<>(query.getIndex(), query.getSize());
        QueryWrapper<ApplicationDO> wrapper = toWrapper(query);
        mapper.selectPage(page, wrapper);
        return page;
    }

    public ApplicationDO selectOne(ApplicationManager.Query query){
        QueryWrapper<ApplicationDO> wrapper = toWrapper(query);
        return mapper.selectOne(wrapper);
    }

    private QueryWrapper<ApplicationDO> toWrapper(ApplicationManager.Query query) {
        QueryWrapper<ApplicationDO> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotEmpty(query.getProjectId())) {
            wrapper.eq("project_id", query.getProjectId());
        }
        if (StringUtils.isNotEmpty(query.getName())) {
            wrapper.eq("name", query.getName());
        }
        if (StringUtils.isNotEmpty(query.getType())) {
            wrapper.eq("type", query.getType());
        }

        return wrapper;
    }

}
