package com.snh.pcs.user.service;

import com.snh.pcs.user.model.User;
import com.snh.pcs.user.model.UserCreateRequest;
import com.snh.pcs.user.model.UserDTO;

public interface UserDetailService {
	User loadUserByUsername(String userEmail);
}