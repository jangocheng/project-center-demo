package com.lytongxue.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lytongxue.api.ProjectServiceApi;
import com.lytongxue.api.domain.Page;
import com.lytongxue.api.domain.dto.ApplicationDTO;
import com.lytongxue.api.domain.dto.ProjectDTO;
import com.lytongxue.api.domain.query.ApplicationQuery;
import com.lytongxue.api.domain.query.ProjectQuery;
import com.lytongxue.domain.Pagination;
import com.lytongxue.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0")
public class ProjectServiceApiImpl implements ProjectServiceApi {

    @Autowired
    private ProjectService service;

    @Override
    public ProjectDTO detail(String id) {
        return service.detail(id);
    }

    @Override
    public Page<ProjectDTO> listPage(ProjectQuery query) {
        return toPage(service.listPage(query));
    }

    @Override
    public Page<ApplicationDTO> listApplicationPage(String projectId, ApplicationQuery query) {
        return toPage(service.listApplicationPage(projectId, query));
    }

    public <T> Page<T> toPage(Pagination<T> paginationDemo) {
        return new Page(paginationDemo.getTotal(), paginationDemo.getRows());
    }

}
