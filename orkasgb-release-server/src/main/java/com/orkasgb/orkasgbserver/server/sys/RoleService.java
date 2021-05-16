package com.orkasgb.orkasgbserver.server.sys;


import com.orkasgb.orkasgbserver.dao.sys.RoleDao;
import com.orkasgb.orkasgbserver.entity.RoleEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    RoleDao roleDao;

    public void addRole(RoleEntity roleEntity) {
        roleDao.addRole(roleEntity);
    }

    public List<RoleEntity> getRoleList(RoleEntity roleEntity) {
        return roleDao.getRoleList(roleEntity);
    }

    public int deleteRole(RoleEntity roleEntity) {
        return roleDao.deleteRole(roleEntity);
    }
}
