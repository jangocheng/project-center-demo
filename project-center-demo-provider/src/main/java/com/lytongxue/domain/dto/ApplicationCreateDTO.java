package com.lytongxue.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ApplicationCreateDTO {

    @NotBlank(message = "应用名不能为空")
    private String name;

    private String description;

    @Pattern(regexp = "BACK|FRONT", message = "应用类型错误")
    private String type;

}
