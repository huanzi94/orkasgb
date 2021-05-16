package com.orkasgb.orkasgbserver.server.sys;


import com.orkasgb.orkasgbserver.dao.sys.RightDao;
import com.orkasgb.orkasgbserver.entity.RightEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RightService {

    @Resource
    RightDao rightDao;

    public List<RightEntity> getRightList(RightEntity rightEntity) {
        return rightDao.getRightList(rightEntity);
    }

    public void addRight(List<RightEntity> rightEntity) {
        rightDao.addRight(rightEntity);
    }

    public int deleteRight(RightEntity rightEntity) {
        return rightDao.deleteRight(rightEntity);
    }
}
