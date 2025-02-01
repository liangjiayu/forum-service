package com.me.forum.admin.dto;

import com.me.forum.admin.enums.GenderEnum;
import com.me.forum.common.validator.ValidEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;


@Data
public class SysUserDto {

    public interface CreateUser extends Default {
    }

    @Schema(description = "用户名，唯一")
    @NotBlank(message = "用户名不能为空", groups = CreateUser.class)
    @Pattern(regexp = "^[A-Za-z0-9]{6,20}$", message = "用户名必须是6-20位的英文或数字", groups = CreateUser.class)
    private String username;

    @Schema(description = "用户密码")
    @NotBlank(message = "密码不能为空", groups = CreateUser.class)
    @Pattern(regexp = "^[A-Za-z0-9]{6,20}$", message = "密码必须是6-20位的英文或数字", groups = CreateUser.class)
    private String password;

    @Schema(description = "用户手机号", example = "13812345678")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不合法")
    private String phoneNumber;

    @Schema(description = "用户性别，枚举类型：男(1)、女(2)、其他(3)", example = "1")
    @ValidEnum(enumClass = GenderEnum.class, message = "性别编码不合法")
    private Integer gender;

    @Schema(description = "用户称呼", example = "小明")
    @Size(min = 2, max = 16, message = "用户称呼长度为2-16位")
    private String nickname;

    @Schema(description = "用户头像的URL", example = "https://www.picture.com/")
    @URL(message = "头像地址格式错误")
    private String profilePictureUrl;

    @Schema(description = "用户简介", example = "个性签名")
    private String profileDescription;

    @Schema(description = "用户元数据，存储额外的自定义信息")
    private String metadata;
}
