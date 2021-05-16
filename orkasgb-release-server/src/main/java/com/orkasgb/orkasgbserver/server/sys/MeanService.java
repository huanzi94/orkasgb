package com.orkasgb.orkasgbserver.server.sys;


import com.orkasgb.orkasgbserver.dao.sys.MeanuDao;
import com.orkasgb.orkasgbserver.entity.MeanuEntity;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeanService {

    @Resource
    MeanuDao meanuDao;

    /**
     * 增加菜单
     *
     * @param meanuEntity
     */
    public void addMean(MeanuEntity meanuEntity) {
        meanuDao.addMean(meanuEntity);
    }

    public List<MeanuEntity> getMeanuList(MeanuEntity meanuEntity) {
        return meanuDao.getMeanuList(meanuEntity);
    }

    public MeanuEntity getMeanuByMeanNo(MeanuEntity meanuEntity) {
        return meanuDao.getMeanuByMeanNo(meanuEntity);
    }

    public int deleteMeanu(MeanuEntity meanuEntity) {
        return meanuDao.deleteMeanu(meanuEntity);
    }

    public List<MeanuEntity> getMenuByOperator(OperatorEntity operatorEntity, String meanuLev) {
        // 查询菜单
        List<MeanuEntity> meanuList = meanuDao.getMenuByOperator(operatorEntity, meanuLev);
        List<MeanuEntity> parentMeanuList = meanuList.stream().filter(meanuEntity -> StringUtils.isBlank(meanuEntity.getMeanuParentNo())).collect(Collectors.toList());
        // 循环父菜单，查询每个父菜单下的子菜单
        parentMeanuList.forEach(meanuEntity -> meanuEntity.setChildren(handleChildrenMeanu(meanuEntity.getMeanuNo(), meanuList)));
        return parentMeanuList;
    }

    public List<MeanuEntity> handleChildrenMeanu(String meanuNo, List<MeanuEntity> meanuEntity) {
        List<MeanuEntity> childrenMeanuList = new ArrayList<>();
        meanuEntity.forEach(meanu -> {
            if (StringUtils.equals(meanuNo, meanu.getMeanuParentNo())) {
                childrenMeanuList.add(meanu);
            }
        });
        childrenMeanuList.forEach(childrenMeanu -> handleChildrenMeanu(childrenMeanu.getMeanuNo(), meanuEntity));
        return childrenMeanuList;
    }

    public void updateMean(MeanuEntity meanuEntity) {
        meanuDao.updateMean(meanuEntity);
    }
}
