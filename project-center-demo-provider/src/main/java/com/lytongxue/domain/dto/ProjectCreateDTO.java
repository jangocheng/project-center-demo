package com.lytongxue.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProjectCreateDTO {

    @NotBlank(message = "工程名不能为空")
    private String name;

    private String description;

}
