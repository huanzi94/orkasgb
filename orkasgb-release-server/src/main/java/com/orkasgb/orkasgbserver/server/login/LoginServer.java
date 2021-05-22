package com.orkasgb.orkasgbserver.server.login;

import com.orkasgb.orkasgbserver.dao.login.LoginDao;
import com.orkasgb.orkasgbserver.dao.sys.RightDao;
import com.orkasgb.orkasgbserver.dao.sys.RoleDao;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.entity.RightEntity;
import com.orkasgb.orkasgbserver.entity.RoleEntity;
import com.orkasgb.orkasgbserver.security.UserSecurityHandle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("loginServer")
public class LoginServer {

    @Resource
    LoginDao loginDao;

    @Resource
    RoleDao roleDao;

    @Resource
    RightDao rightDao;

    @Resource
    UserSecurityHandle securityHandle;

    public OperatorEntity loginValidate(OperatorEntity operatorEntity) {
        String loginId = operatorEntity.getOperatorLoginId();
        OperatorEntity operator = loginDao.loginValidate(operatorEntity);
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setOperatorNo(operator.getOperatorNo());
        List<RoleEntity> roleEntityList = roleDao.getRoleList(roleEntity);
        securityHandle.setRoleList(roleEntityList, loginId);

        RightEntity rightEntity = new RightEntity();
        rightEntity.setOperatorNo(operator.getOperatorNo());
        List<RightEntity> rightEntityList = rightDao.getRightList(rightEntity);
        securityHandle.setPermissionList(rightEntityList, loginId);
        return operator;
    }

}
