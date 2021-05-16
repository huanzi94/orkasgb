package com.orkasgb.orkasgbserver.dao.sys;

import com.orkasgb.orkasgbserver.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

    List<DepartmentEntity> getDepartment(DepartmentEntity departmentEntity);

    void addDepartment(DepartmentEntity departmentEntity);

    int deleteDepartment(DepartmentEntity departmentEntity);
}
