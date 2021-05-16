package com.orkasgb.orkasgbserver.dao.sys;

import com.orkasgb.orkasgbserver.entity.RightEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RightDao {

    List<RightEntity> getRightList(RightEntity rightEntity);

    void addRight(List<RightEntity> rightEntity);

    RightEntity getRightByNo(RightEntity rightEntity);

    int deleteRight(RightEntity rightEntity);
}
