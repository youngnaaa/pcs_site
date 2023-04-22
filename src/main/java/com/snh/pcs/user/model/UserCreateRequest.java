package com.snh.pcs.user.model;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

	@NotNull
    private String email;

    @NotNull
    private String passWord;
}