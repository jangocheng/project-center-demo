package com.lytongxue.api.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApplicationDTO implements Serializable {

    private String id;

    private String projectId;

    private String name;

    private String description;

    private String type;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

}
