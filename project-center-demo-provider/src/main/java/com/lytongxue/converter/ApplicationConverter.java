package com.lytongxue.converter;

import com.lytongxue.api.domain.dto.ApplicationDTO;
import com.lytongxue.api.domain.query.ApplicationQuery;
import com.lytongxue.api.domain.vo.ApplicationVO;
import com.lytongxue.domain.dto.ApplicationCreateDTO;
import com.lytongxue.domain.entity.ApplicationDO;
import com.lytongxue.service.project.manager.ApplicationManager.Create;
import com.lytongxue.service.project.manager.ApplicationManager.Query;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ApplicationConverter {

    Query createModel2QueryModel(Create createModel);

    ApplicationDO createModel2Do(Create createModel);

    Create dto2CreateModel(ApplicationCreateDTO dto);

    Query query2QueryModel(ApplicationQuery query);

    ApplicationDTO do2Dto(ApplicationDO entity);

    ApplicationVO dto2Vo(ApplicationDTO dto);

}
