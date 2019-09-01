package com.lytongxue.api.domain.query;

import com.lytongxue.api.domain.PageRequest;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ApplicationQuery extends PageRequest {

    @ApiParam(value = "应用名称")
    private String name;

    @ApiParam(value = "工程Id")
    private String projectId;

    @ApiParam(value = "应用类型")
    @Pattern(regexp = "FRONT|BACK", message = "应用类型仅能为 FRONT 或 BACK")
    private String type;
}
