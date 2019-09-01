package com.lytongxue.api.domain.query;

import com.lytongxue.api.domain.PageRequest;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class ProjectQuery extends PageRequest {

    @ApiParam(value = "按工程名称过滤")
    private String name;

}
