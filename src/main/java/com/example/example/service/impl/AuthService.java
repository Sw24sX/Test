package com.example.example.service.impl;

import com.example.example.domain.enums.RoleType;
import com.example.example.domain.repository.UserInfoRepository;
import com.example.example.service.AuthServiceApi;
import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;
import com.example.example.service.dto.service.UserInfoDetails;
import com.example.example.service.exception.NotFoundException;
import com.example.example.service.factory.UserInfoFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService, AuthServiceApi {

    private final UserInfoRepository userInfoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userInfo = userInfoRepository.findByLogin(username)
                .orElseThrow(() -> new NotFoundException("User with username %s not found", username));

        return new UserInfoDetails(userInfo);
    }

    @Override
    @Transactional
    public UserInfoDto registerUser(CreateUserInfoRequest request) {
        var userInfo = UserInfoFactory.from(request);
        userInfo.setPassword(encodePassword(request.getPassword()));
        userInfo.setRoles(List.of(RoleType.USER));
        var result = userInfoRepository.save(userInfo);
        return UserInfoFactory.to(result);
    }

    @Override
    public UserInfoDto login(String username) {
        var result = userInfoRepository.findByLogin(username)
                .orElseThrow(() -> new NotFoundException("User not found by login %s", username));
        return UserInfoFactory.to(result);
    }

    private String encodePassword(char[] password) {
        return bCryptPasswordEncoder.encode(CharBuffer.wrap(password));
    }
}
