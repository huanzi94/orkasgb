package com.orkasgb.orkasgbserver.dao.common;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonDao {
    boolean hasRole(String roleNo);

    String getNextValueByTableName(String tableName);

    int addNextValueByTableName(String tableName, String defaultCurrentSerialKey, String defaultNextSerialKey);

    int updateNextValueByTableName(String tableName);
}

