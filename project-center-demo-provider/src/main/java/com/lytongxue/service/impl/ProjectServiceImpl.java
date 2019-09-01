package com.lytongxue.service.impl;

import com.lytongxue.api.domain.dto.ApplicationDTO;
import com.lytongxue.api.domain.dto.ProjectDTO;
import com.lytongxue.api.domain.query.ApplicationQuery;
import com.lytongxue.api.domain.query.ProjectQuery;
import com.lytongxue.converter.ApplicationConverter;
import com.lytongxue.converter.ProjectConverter;
import com.lytongxue.domain.Pagination;
import com.lytongxue.domain.dto.ApplicationCreateDTO;
import com.lytongxue.domain.dto.ProjectCreateDTO;
import com.lytongxue.domain.entity.ProjectDO;
import com.lytongxue.service.ProjectService;
import com.lytongxue.service.project.entity.Application;
import com.lytongxue.service.project.entity.Project;
import com.lytongxue.service.project.manager.ApplicationManager;
import com.lytongxue.service.project.manager.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ApplicationManager applicationManager;

    @Autowired
    private ProjectConverter projectConverter;

    @Autowired
    private ApplicationConverter applicationConverter;

    public ProjectDTO detail(String id) {
        Project project = projectManager.get(id);
        ProjectDO entity = project.data();
        return projectConverter.do2Dto(entity);
    }

    public String create(ProjectCreateDTO dto) {
        ProjectManager.Create createModel = projectConverter.dto2CreateModel(dto);
        Project project = projectManager.create(createModel);
        return project.getId();
    }

    public List<ProjectDTO> list(ProjectQuery query) {
        ProjectManager.Query queryModel = projectConverter.query2QueryModel(query);
        List<Project> listProjects = projectManager.list(queryModel);
        return toProjectDTO(listProjects);
    }

    public Pagination<ProjectDTO> listPage(ProjectQuery query) {
        ProjectManager.Query queryModel = projectConverter.query2QueryModel(query);
        Pagination<Project> page = projectManager.listPage(queryModel);
        return new Pagination<>(page.getTotal(), toProjectDTO(page.getRows()));
    }

    public String createApplication(String projectId, ApplicationCreateDTO dto) {
        return projectManager
                .get(projectId)
                .createApplication(applicationConverter.dto2CreateModel(dto))
                .getId();
    }

    public Pagination<ApplicationDTO> listApplicationPage(String projectId, ApplicationQuery query) {
        Project project = projectManager.get(projectId);
        ApplicationManager.Query queryModel = applicationConverter.query2QueryModel(query);
        Pagination<Application> page = project.listApplicationPage(queryModel);
        return new Pagination<>(page.getTotal(), toApplicationDTO(page.getRows()));
    }

    private List<ProjectDTO> toProjectDTO(List<Project> projects) {
        return projects
                .stream()
                .map(project -> projectConverter.do2Dto(project.data()))
                .collect(Collectors.toList());
    }

    private List<ApplicationDTO> toApplicationDTO(List<Application> applications) {
        return applications
                .stream()
                .map(application -> applicationConverter.do2Dto(application.data()))
                .collect(Collectors.toList());
    }
}
