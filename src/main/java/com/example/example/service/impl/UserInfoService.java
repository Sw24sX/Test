package com.example.example.service.impl;

import com.example.example.domain.repository.UserInfoRepository;
import com.example.example.service.UserInfoServiceApi;
import com.example.example.service.dto.response.UserInfoDto;
import com.example.example.service.exception.NotFoundException;
import com.example.example.service.factory.UserInfoFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserInfoServiceApi {

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDto getUserInfoById(Long id) {
        var result = userInfoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found by id %s", id));
        return UserInfoFactory.to(result);
    }


}
