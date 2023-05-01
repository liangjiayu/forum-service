package com.me.forum.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberRegisterDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;
}
