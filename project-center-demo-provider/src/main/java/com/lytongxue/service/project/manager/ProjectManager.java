package com.lytongxue.service.project.manager;

import com.lytongxue.api.domain.PageRequest;
import com.lytongxue.converter.ProjectConverter;
import com.lytongxue.domain.Pagination;
import com.lytongxue.domain.entity.ProjectDO;
import com.lytongxue.exception.common.DataNotFoundException;
import com.lytongxue.exception.common.DataRepetitionException;
import com.lytongxue.service.project.AbstractManager;
import com.lytongxue.service.project.Builder;
import com.lytongxue.service.project.entity.Project;
import com.lytongxue.service.project.repo.ProjectRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ProjectManager extends AbstractManager {

    @Autowired
    private ProjectRepository repo;

    @Autowired
    private Builder builder;

    @Autowired
    private ProjectConverter converter;

    public Project get(String id) {
        ProjectDO entity = repo.selectById(id);
        if (entity == null) {
            throw new DataNotFoundException("工程不存在");
        }
        return builder.buildProject(entity.getId());
    }

    public Project create(Create model) {
        ProjectDO entity = converter.createModel2Do(model);
        if (repo.isExist(entity.getName())) {
            throw new DataRepetitionException("已存在同名工程，无法重复创建");
        }
        String id = repo.create(entity);
        return builder.buildProject(id);
    }

    public List<Project> list(Query query) {
        return this.listDO(query)
                .stream()
                .map(data -> builder.buildProject(data.getId()))
                .collect(Collectors.toList());
    }

    public List<ProjectDO> listDO(Query query) {
        return repo.selectList(query);
    }

    public Pagination<Project> listPage(Query query) {
        Pagination<ProjectDO> pagination = this.listDOPage(query);
        return new Pagination<>(pagination.getTotal(), pagination.getRows()
                .stream()
                .map(data -> builder.buildProject(data.getId()))
                .collect(Collectors.toList()));
    }

    public Pagination<ProjectDO> listDOPage(Query query) {
        return Pagination.from(repo.selectPage(query));
    }

    @Data
    public static class Create {
        private String name;
        private String description;
    }

    @Data
    public static class Query extends PageRequest {
        private String id;
        private String name;
    }

}
