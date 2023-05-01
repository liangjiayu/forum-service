package com.me.forum.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberLoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
