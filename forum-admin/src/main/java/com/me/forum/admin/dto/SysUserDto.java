package com.me.forum.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SysUserDto {
    @Schema(description = "用户id")
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
}
