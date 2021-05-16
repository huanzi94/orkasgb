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
    private static Map<String, List<String>> permissionMap = new HashMap<>();

    private static Map<String, List<String>> roleMap = new HashMap<>();

    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        return this.permissionMap.get(loginId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        return this.roleMap.get(loginId);
    }

    public void setPermissionList(List<RightEntity> permissionList, String loginId) {
        List<String> permission = permissionList.stream().map(RightEntity::getMeanuUrl).collect(Collectors.toList());
        this.permissionMap.put(loginId, permission);
    }

    public void setRoleList(List<RoleEntity> roleList, String loginId) {
        List<String> roles = roleList.stream().map(RoleEntity::getRoleType).collect(Collectors.toList());
        this.roleMap.put(loginId, roles);
    }
}
