package com.lytongxue.service.project.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lytongxue.domain.entity.ProjectDO;
import com.lytongxue.mapper.ProjectMapper;
import com.lytongxue.service.project.manager.ProjectManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectRepository {

    @Autowired
    private ProjectMapper mapper;

    public ProjectDO selectById(String id) {
        return mapper.selectById(id);
    }

    public String create(ProjectDO entity) {
        mapper.insert(entity);
        return entity.getId();
    }

    public Integer updateById(ProjectDO entity) {
        return mapper.updateById(entity);
    }

    public Boolean isExist(String name) {
        return mapper.selectCount(new QueryWrapper<ProjectDO>()
                .eq("name", name)
        ) > 0;
    }

    public List<ProjectDO> selectList(ProjectManager.Query query) {
        return selectPage(query).getRecords();
    }

    public Page<ProjectDO> selectPage(ProjectManager.Query query) {
        Page<ProjectDO> page = new Page<>(query.getIndex(), query.getSize());
        QueryWrapper<ProjectDO> wrapper = toWrapper(query);
        mapper.selectPage(page, wrapper);
        return page;
    }

    private QueryWrapper<ProjectDO> toWrapper(ProjectManager.Query query) {
        QueryWrapper<ProjectDO> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotEmpty(query.getName())) {
            wrapper.like("name", query.getName());
        }

        return wrapper;
    }

}
