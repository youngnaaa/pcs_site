package com.snh.pcs.user.service.impl;

import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.snh.pcs.user.model.User;
import com.snh.pcs.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository = null;

    @Override
    public User loadUserByUsername(String userEmail) {
        return Optional.ofNullable(userRepository.findByEmail(userEmail)).orElseThrow(() -> new BadCredentialsException("이메일 주소를 확인해주세요."));
    }

}