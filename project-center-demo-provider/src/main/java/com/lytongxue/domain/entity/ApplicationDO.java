package com.lytongxue.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.lytongxue.enums.ApplicationType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("application")
public class ApplicationDO {

    @TableId(type = IdType.UUID)
    private String id;

    private String projectId;

    private String name;

    private String description;

    private ApplicationType type;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer dr;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;

    @TableField(fill = FieldFill.UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.UPDATE)
    private Date updatedAt;

}
