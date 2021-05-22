package com.orkasgb.orkasgbserver.security;

import cn.dev33.satoken.stp.StpInterface;
import com.orkasgb.orkasgbserver.entity.RightEntity;
import com.orkasgb.orkasgbserver.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserSecurityHandle implements StpInterface {
    private static final Map<String, List<String>> permissionMap = new HashMap<>();

    private static final Map<String, List<String>> roleMap = new HashMap<>();

    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        return permissionMap.get(loginId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        return roleMap.get(loginId);
    }

    public void setPermissionList(List<RightEntity> permissionList, String loginId) {
        List<String> permission = permissionList.stream().map(RightEntity::getMeanuUrl).collect(Collectors.toList());
        permissionMap.put(loginId, permission);
    }

    public void setRoleList(List<RoleEntity> roleList, String loginId) {
        List<String> roles = roleList.stream().map(RoleEntity::getRoleType).collect(Collectors.toList());
        roleMap.put(loginId, roles);
    }
}
