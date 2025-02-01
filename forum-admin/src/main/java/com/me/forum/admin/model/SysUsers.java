package com.me.forum.admin.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.me.forum.admin.enums.GenderEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_users")
public class SysUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "用户名，唯一")
    private String username;

    @Schema(description = "用户密码")
    private String password;

    @Schema(description = "用户手机号", example = "13812345678")
    private String phoneNumber;

    @Schema(description = "用户性别，枚举类型：男性(1)、女性(2)、其他(3)", example = "1")
    private Integer gender;

    @TableField(exist = false)
    @Schema(description = "性别文本", example = "男性")
    private Integer genderText;
    @JsonInclude
    public String getGenderText() {
        return GenderEnum.fromCode(gender).getText();
    }

    @Schema(description = "用户称号", example = "小明")
    private String nickname;

    @Schema(description = "用户头像的URL", example = "https://www.picture.com/")
    private String profilePictureUrl;

    @Schema(description = "用户简介", example = "个性签名")
    private String profileDescription;

    @Schema(description = "用户元数据，存储额外的自定义信息")
    private String metadata;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @Schema(description = "逻辑删除标识", example = "0")
    @TableLogic
    private Integer isDeleted;
}
