package com.orkasgb.orkasgbserver.dao.datahandle;

import com.orkasgb.orkasgbserver.entity.CurveData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataHandleDao {

    void insertHandleData(List<CurveData> curveData);

    void deleteHandleData(CurveData curveData);

    List<CurveData> getCurveDataList(CurveData curveData);
}
