package com.orkasgb.orkasgbserver.server.common;

import com.orkasgb.orkasgbserver.dao.common.CommonDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommonServer {

    public static final String DEFAULT_CURRENT_SERIAL_KEY = "10000";

    public static final String DEFAULT_NEXT_SERIAL_KEY = "10001";

    @Resource
    CommonDao commonDao;

    public String getNextValueByTableName(String tableName) throws DataAccessException {
        String nextValue = commonDao.getNextValueByTableName(tableName);
        if (StringUtils.isBlank(nextValue)) {
            commonDao.addNextValueByTableName(tableName, DEFAULT_CURRENT_SERIAL_KEY, DEFAULT_NEXT_SERIAL_KEY);
        } else {
            commonDao.updateNextValueByTableName(tableName);
        }
        return StringUtils.isBlank(nextValue) ? DEFAULT_NEXT_SERIAL_KEY : nextValue;
    }
}
