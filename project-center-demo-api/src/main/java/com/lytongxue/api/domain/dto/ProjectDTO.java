package com.lytongxue.api.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectDTO implements Serializable {

    private String id;

    private String name;

    private String description;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

}
