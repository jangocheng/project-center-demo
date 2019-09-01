package com.lytongxue.api.domain.vo;


import lombok.Data;

import java.util.Date;

@Data
public class ApplicationVO {

    private String id;

    private String projectId;

    private String name;

    private String description;

    private String type;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

}
