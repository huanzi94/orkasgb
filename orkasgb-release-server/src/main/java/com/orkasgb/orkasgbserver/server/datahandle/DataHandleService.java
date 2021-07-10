package com.orkasgb.orkasgbserver.server.datahandle;

import com.orkasgb.orkasgbserver.dao.datahandle.DataHandleDao;
import com.orkasgb.orkasgbserver.entity.CurveData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataHandleService {

    private static final Random RANDOM = new Random(10000);

    @Resource
    DataHandleDao dataHandleDao;

    public void downloadDataHandle() {
        CurveData curveData = new CurveData();
        curveData.setDataType("1");
        List<CurveData> curveDataList = generateCurveDataTemplte(curveData, Arrays.asList("光宇", "王者荣耀", "元神", "和平经营"));
        assert curveDataList != null;
        curveDataList.forEach(curve -> {
            int ra = RANDOM.nextInt(1000) + 100;
            curve.setValue(String.valueOf(ra));
        });

        dataHandleDao.insertHandleData(curveDataList);
    }

    public void accessDataHandle() {
        CurveData curveData = new CurveData();
        curveData.setDataType("2");
        List<CurveData> curveDataList = generateCurveDataTemplte(curveData, Arrays.asList("光宇", "王者荣耀", "元神", "和平经营"));
        assert curveDataList != null;
        curveDataList.forEach(curve -> {
            int ra = RANDOM.nextInt(1000) + 100;
            curve.setValue(String.valueOf(ra));
        });

        dataHandleDao.insertHandleData(curveDataList);
    }

    private List<CurveData> generateCurveDataTemplte(CurveData curveData, List<String> dataNames) {
        if (CollectionUtils.isEmpty(dataNames)) {
            return null;
        }

        List<CurveData> curveDataList = new ArrayList<>(dataNames.size());
        Date date = new Date();
        long ch = date.getTime() % 300000L;
        long cd = date.getTime() - ch;
        date.setTime(cd);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        dataNames.forEach(name -> {
            CurveData curve = new CurveData();
            BeanUtils.copyProperties(curveData, curve);
            curve.setDataName(name);
            curve.setTime(sdf.format(date));
            curveDataList.add(curve);
        });

        return curveDataList;
    }

    public Object getCurveDataList(CurveData curveData) {
        List<CurveData> curveDataList = dataHandleDao.getCurveDataList(curveData);
        if (StringUtils.equals("1", curveData.getDataType())) {
            return curveDataList.stream().collect(Collectors.groupingBy(CurveData::getDataName,
                    Collectors.reducing(BigDecimal.ZERO, curve -> StringUtils.isBlank(curve.getValue()) ?
                            BigDecimal.ZERO : new BigDecimal(curve.getValue()), BigDecimal::add)));

        }
        if (StringUtils.equals("2", curveData.getDataType())) {
            return curveDataList.stream().collect(Collectors.groupingBy(CurveData::getDataName));
        }
        return curveDataList;
    }
}
