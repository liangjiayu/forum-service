package com.me.forum.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_users")
public class SysUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "用户名，唯一且不能为空")
    private String username;

    @Schema(description = "用户密码")
    private String password;

    @Schema(description = "用户手机号，唯一")
    private String phoneNumber;

    @Schema(description = "用户性别，枚举类型：男(1)、女(2)、其他(3)")
    private Integer gender;

    @Schema(description = "用户头像的URL")
    private String profilePictureUrl;

    @Schema(description = "用户简介")
    private String profileDescription;

    @Schema(description = "用户元数据，存储额外的自定义信息")
    private String metadata;

    @Schema(description = "创建时间")
    private Date createdAt;

    @Schema(description = "更新时间")
    private Date updatedAt;

    @Schema(description = "逻辑删除标识")
    @TableLogic
    private Integer isDeleted;
}
