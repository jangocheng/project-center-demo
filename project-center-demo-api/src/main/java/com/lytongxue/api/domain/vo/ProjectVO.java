package com.lytongxue.api.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectVO {

    private String id;

    private String name;

    private String description;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

}
