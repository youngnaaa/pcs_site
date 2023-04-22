package com.snh.pcs.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

	private Long id;

    private String email;

    private String password;


    @Builder
    private UserDTO(Long id, String password, String email) {
    	this.id = id;
        this.password = password;
        this.email = email;
    }
}