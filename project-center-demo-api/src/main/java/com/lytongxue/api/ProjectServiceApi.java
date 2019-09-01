package com.lytongxue.api;

import com.lytongxue.api.domain.Page;
import com.lytongxue.api.domain.dto.ApplicationDTO;
import com.lytongxue.api.domain.dto.ProjectDTO;
import com.lytongxue.api.domain.query.ApplicationQuery;
import com.lytongxue.api.domain.query.ProjectQuery;

public interface ProjectServiceApi {

    /**
     * 获取工程详情
     * @param id
     * @return ProjectDTO
     */
    ProjectDTO detail(String id);

    /**
     * 获取工程列表
     * @param query
     * @return Page<ProjectDTO>
     */
    Page<ProjectDTO> listPage(ProjectQuery query);

    /**
     * 获取应用列表
     * @param projectId
     * @param query
     * @return Page<ApplicationDTO>
     */
    Page<ApplicationDTO> listApplicationPage(String projectId, ApplicationQuery query);

}
