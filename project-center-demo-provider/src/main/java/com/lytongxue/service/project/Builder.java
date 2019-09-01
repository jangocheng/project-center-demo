package com.lytongxue.service.project;

import com.lytongxue.service.project.entity.Application;
import com.lytongxue.service.project.entity.Project;
import com.lytongxue.service.project.manager.ApplicationManager;
import com.lytongxue.service.project.manager.ProjectManager;
import com.lytongxue.service.project.repo.ApplicationRepository;
import com.lytongxue.service.project.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Builder {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    private ProjectManager projectManager;

    private ApplicationManager applicationManager;

    @Autowired
    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    @Autowired
    public void setApplicationManager(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    public Project buildProject(String projectId) {
        Project project = new Project(projectId, projectRepository, applicationManager);
        return project;
    }

    public Application buildApplication(String applicationId) {
        Application application = new Application(applicationId, applicationRepository, projectManager, applicationManager);
        return application;
    }

}
