package com.lytongxue.service.project.entity;

import com.lytongxue.converter.ProjectConverter;
import com.lytongxue.domain.Pagination;
import com.lytongxue.domain.entity.ProjectDO;
import com.lytongxue.exception.common.DataNotFoundException;
import com.lytongxue.service.project.DomainEntity;
import com.lytongxue.service.project.manager.ApplicationManager;
import com.lytongxue.service.project.repo.ProjectRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Project extends DomainEntity<String, ProjectRepository> {

    private ApplicationManager applicationManager;

    @Autowired
    private ProjectConverter converter;

    public Project(String id, ProjectRepository repo, ApplicationManager applicationManager) {
        super(id, repo);
        this.applicationManager = applicationManager;
    }

    public ProjectDO data() {
        return this.getRepo().selectById(this.getId());
    }

    public void update(Update model) {
        ProjectDO entity = converter.updateModel2Do(model);
        entity.setId(this.getId());
        this.getRepo().updateById(entity);
    }

    public Application createApplication(ApplicationManager.Create model) {
        model.setProjectId(this.getId());
        return applicationManager.create(model);
    }

    public Application getAppcalition(String applicationId) {
        ApplicationManager.Query query = new ApplicationManager.Query();
        query.setProjectId(this.getId());
        query.setId(applicationId);
        Application application = applicationManager.find(query);
        if (application == null) {
            throw new DataNotFoundException("应用不存在");
        }
        return application;
    }

    public List<Application> listApplications(ApplicationManager.Query query) {
        query.setProjectId(this.getId());
        return applicationManager.list(query);
    }

    public Pagination<Application> listApplicationPage(ApplicationManager.Query query) {
        query.setProjectId(this.getId());
        return applicationManager.listPage(query);
    }

    @Data
    public static class Update {
        private String description;
    }

}
