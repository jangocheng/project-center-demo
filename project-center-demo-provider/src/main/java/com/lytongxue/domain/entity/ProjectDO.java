package com.lytongxue.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@TableName("project")
@ToString
public class ProjectDO {

    @TableId(type = IdType.UUID)
    private String id;

    private String name;

    private String description;

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
