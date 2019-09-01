package com.lytongxue.service;

import com.lytongxue.api.domain.dto.ApplicationDTO;
import com.lytongxue.api.domain.dto.ProjectDTO;
import com.lytongxue.api.domain.query.ApplicationQuery;
import com.lytongxue.api.domain.query.ProjectQuery;
import com.lytongxue.domain.Pagination;
import com.lytongxue.domain.dto.ApplicationCreateDTO;
import com.lytongxue.domain.dto.ProjectCreateDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO detail(String id);

    String create(ProjectCreateDTO dto);

    List<ProjectDTO> list(ProjectQuery query);

    Pagination<ProjectDTO> listPage(ProjectQuery query);

    String createApplication(String projectId, ApplicationCreateDTO dto);

    Pagination<ApplicationDTO> listApplicationPage(String projectId, ApplicationQuery query);

}
