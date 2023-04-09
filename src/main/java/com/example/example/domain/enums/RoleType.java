package com.example.example.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleType {
    ADMIN("admin", "ROLE_ADMIN"),
    USER("user", "ROLE_USER");

    private final String id;
    private final String roleName;
}
