package com.lytongxue.service.project.manager;

import com.lytongxue.api.domain.PageRequest;
import com.lytongxue.converter.ApplicationConverter;
import com.lytongxue.domain.Pagination;
import com.lytongxue.domain.entity.ApplicationDO;
import com.lytongxue.exception.common.DataExistException;
import com.lytongxue.exception.common.DataNotFoundException;
import com.lytongxue.service.project.AbstractManager;
import com.lytongxue.service.project.Builder;
import com.lytongxue.service.project.entity.Application;
import com.lytongxue.service.project.repo.ApplicationRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ApplicationManager extends AbstractManager {

    @Autowired
    private ApplicationRepository repo;

    @Autowired
    private Builder builder;

    @Autowired
    private ApplicationConverter converter;

    public Application get(String id) {
        ApplicationDO entity = repo.selectById(id);
        if(entity == null){
            throw new DataNotFoundException("应用不存在");
        }
        return builder.buildApplication(entity.getId());
    }

    public Application find(Query query) {
        ApplicationDO entity = repo.selectOne(query);
        if (entity == null) {
            return null;
        }
        return builder.buildApplication(entity.getId());
    }

    public Application create(Create model) {
        checkIsExist(converter.createModel2QueryModel(model));
        ApplicationDO entity = converter.createModel2Do(model);
        repo.create(entity);
        return builder.buildApplication(entity.getId());
    }

    public void checkIsExist(Query query) {
        ApplicationDO applicationDO = repo.selectOne(query);
        if (applicationDO != null) {
            throw new DataExistException("当前应用已存在");
        }
    }

    public List<Application> list(Query query) {
        return repo
                .selectList(query)
                .stream()
                .map(data -> builder.buildApplication(data.getId()))
                .collect(Collectors.toList());
    }

    public List<ApplicationDO> listDO(Query query) {
        return repo.selectList(query);
    }

    public Pagination<Application> listPage(Query query) {
        Pagination<ApplicationDO> pagination = this.listDOPage(query);
        return new Pagination<>(pagination.getTotal(), pagination.getRows()
                .stream()
                .map(data -> builder.buildApplication(data.getId()))
                .collect(Collectors.toList()));
    }

    public Pagination<ApplicationDO> listDOPage(Query query) {
        return Pagination.from(repo.selectPage(query));
    }

    @Data
    public static class Create {
        private String projectId;
        private String name;
        private String description;
        private String type;
    }

    @Data
    public static class Query extends PageRequest {
        private String id;
        private String projectId;
        private String name;
        private String type;
    }

}
