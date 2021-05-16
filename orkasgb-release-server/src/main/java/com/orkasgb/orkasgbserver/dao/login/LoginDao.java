package com.orkasgb.orkasgbserver.dao.login;

import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    OperatorEntity loginValidate(OperatorEntity operatorEntity);
}
