package com.lytongxue.converter;

import com.lytongxue.api.domain.dto.ProjectDTO;
import com.lytongxue.api.domain.query.ProjectQuery;
import com.lytongxue.api.domain.vo.ProjectVO;
import com.lytongxue.domain.dto.ProjectCreateDTO;
import com.lytongxue.domain.entity.ProjectDO;
import com.lytongxue.service.project.entity.Project.Update;
import com.lytongxue.service.project.manager.ProjectManager.Create;
import com.lytongxue.service.project.manager.ProjectManager.Query;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectConverter {

    ProjectDTO do2Dto(ProjectDO entity);

    ProjectVO dto2Vo(ProjectDTO dto);

    ProjectDO createModel2Do(Create createModel);

    Query query2QueryModel(ProjectQuery query);

    Create dto2CreateModel(ProjectCreateDTO dto);

    ProjectDO updateModel2Do(Update dto);

}
