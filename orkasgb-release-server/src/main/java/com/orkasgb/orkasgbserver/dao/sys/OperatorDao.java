package com.orkasgb.orkasgbserver.dao.sys;

import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OperatorDao {

    void addOperator(OperatorEntity operatorEntity) throws DataAccessException;

    int deleteOperator(OperatorEntity operatorEntity) throws DataAccessException;

    List<OperatorEntity> getOperatorList(OperatorEntity operatorEntity) throws DataAccessException;

    void updateOperator(OperatorEntity operatorEntity) throws DataAccessException;
}
