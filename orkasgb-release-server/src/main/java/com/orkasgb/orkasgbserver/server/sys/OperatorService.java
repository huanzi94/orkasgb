package com.orkasgb.orkasgbserver.server.sys;


import cn.dev33.satoken.secure.SaSecureUtil;
import com.orkasgb.orkasgbserver.dao.sys.OperatorDao;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Configurable
public class OperatorService {

    @Resource
    OperatorDao operatorDao;
    @Value("${security.publicKey}")
    private String publicKey;
    @Value("${security.privateKey}")
    private String privateKey;

    public void addOperator(OperatorEntity operatorEntity) throws DataAccessException {
        String securityPwd = SaSecureUtil.rsaEncryptByPublic(publicKey, operatorEntity.getOperatorPwd());
        operatorEntity.setOperatorPwd(securityPwd);
        operatorDao.addOperator(operatorEntity);
    }

    public int deleteOperator(OperatorEntity operatorEntity) throws DataAccessException {
        return operatorDao.deleteOperator(operatorEntity);
    }

    public List<OperatorEntity> getOperatorList(OperatorEntity operatorEntity) throws DataAccessException {
        return operatorDao.getOperatorList(operatorEntity);
    }

    public void updateOperator(OperatorEntity operatorEntity) throws DataAccessException {
        operatorDao.updateOperator(operatorEntity);
    }

    public String updatePassword(OperatorEntity operatorEntity) throws DataAccessException {
        List<OperatorEntity> operatorList = this.getOperatorList(operatorEntity);
        if (CollectionUtils.isEmpty(operatorList)) {
            return "Illegal access to user information";
        }

        OperatorEntity operator = operatorList.get(0);
        String password = operator.getOperatorPwd();
        if (StringUtils.isBlank(password)) {
            return "Illegal access to user information";
        }

        String pass = SaSecureUtil.rsaDecryptByPrivate(privateKey, password);
        if (!StringUtils.equals(pass, operatorEntity.getOperatorPwd())) {
            return "The original password is incorrect";
        }

        String newPass = SaSecureUtil.rsaEncryptByPublic(publicKey, operatorEntity.getNewPassword());
        operatorEntity.setOperatorPwd(newPass);
        operatorDao.updateOperator(operatorEntity);
        return "Password modified successfully";
    }
}
