package com.snh.pcs.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.ToString;

@ToString
public class UserDto implements UserDetails {
	
	String ROLE_PREFIX = "ROLE_";
	
	private String id;		//ID
	private String role;	//역할(권한)
	private String loginId;	//reqID
	private String password;//Password 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
	    return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return id;
	}
	
	// 계정 만료 여부(true: 만료되지 않음, false: 만료됨)
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	
	// 계정 잠금 여부(true: 계정잠금아님, false: 계정잠금상태)
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	// 계정 패스워드 만료 여부(true: 만료되지 않음, false: 만료됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	
	// 계정 사용가능 여부(true: 사용가능, false: 사용불가능)
	@Override
	public boolean isEnabled() {
		return false;
	}


	// TODO TEST위하여 임시로 set 만들어둠 
	public void setPassword(String password) {
		this.password = password;
	}

	// TODO TEST위하여 임시로 set 만들어둠 
	public void setUsername(String id) {
		this.id = id;
	}

	// TODO TEST위하여 임시로 set 만들어둠 
	public void setRole(String role) {
		this.role = role;
	}

	
}
