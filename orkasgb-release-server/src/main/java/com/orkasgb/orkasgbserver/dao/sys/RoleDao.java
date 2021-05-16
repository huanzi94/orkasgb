package com.orkasgb.orkasgbserver.dao.sys;

import com.orkasgb.orkasgbserver.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {

    void addRole(RoleEntity roleEntity);

    int deleteRole(RoleEntity roleEntity);

    List<RoleEntity> getRoleList(RoleEntity roleEntity);

    List<RoleEntity> getRoles(String operatorNo);
}
