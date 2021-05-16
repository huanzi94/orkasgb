package com.orkasgb.orkasgbserver.server.sys;


import com.orkasgb.orkasgbserver.dao.sys.DepartmentDao;
import com.orkasgb.orkasgbserver.entity.DepartmentEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    DepartmentDao departmentDao;

    public List<DepartmentEntity> getDepartment(DepartmentEntity departmentEntity) {
        return departmentDao.getDepartment(departmentEntity);
    }

    public void addDepartment(DepartmentEntity departmentEntity) {
        departmentDao.addDepartment(departmentEntity);
    }

    public int deleteDepartment(DepartmentEntity departmentEntity) {
        return departmentDao.deleteDepartment(departmentEntity);
    }
}
