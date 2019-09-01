package com.lytongxue.service.project.entity;

import com.lytongxue.domain.entity.ApplicationDO;
import com.lytongxue.service.project.DomainEntity;
import com.lytongxue.service.project.manager.ApplicationManager;
import com.lytongxue.service.project.manager.ProjectManager;
import com.lytongxue.service.project.repo.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application extends DomainEntity<String, ApplicationRepository> {

    private ProjectManager projectManager;

    private ApplicationManager applicationManager;

    public Application(String id, ApplicationRepository repo, ProjectManager projectManager, ApplicationManager applicationManager) {
        super(id, repo);
        this.projectManager = projectManager;
        this.applicationManager = applicationManager;
    }

    public ApplicationDO data() {
        return this.getRepo().selectById(this.getId());
    }

}

