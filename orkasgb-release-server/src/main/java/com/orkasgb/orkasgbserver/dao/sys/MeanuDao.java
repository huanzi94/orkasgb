package com.orkasgb.orkasgbserver.dao.sys;

import com.orkasgb.orkasgbserver.entity.MeanuEntity;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeanuDao {

    List<MeanuEntity> getMeanuList(MeanuEntity meanuEntity);

    void addMean(MeanuEntity meanuEntity);

    MeanuEntity getMeanuByMeanNo(MeanuEntity meanuEntity);

    int deleteMeanu(MeanuEntity meanuEntity);

    List<MeanuEntity> getMenuByOperator(@Param(value = "operatorEntity") OperatorEntity operatorEntity, @Param(value = "meanuLev") String meanuLev);

    void updateMean(MeanuEntity meanuEntity);
}
