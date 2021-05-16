package com.orkasgb.orkasgbapp.commcode.commenum;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RolesEnum {
    SUPER_ADMIN("SUPER-ADMIN", "1"),
    ADMIN("ADMIN", "2"),
    ORDINARY("ORDINARY", "3"),
    ALL("ALL", "0");

    String value;

    String code;

    RolesEnum(String value, String code) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(String code) {
        List<RolesEnum> list = Arrays.stream(RolesEnum.values()).filter(rolesEnum -> StringUtils.equalsIgnoreCase(rolesEnum.code, code)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0).value;
        }
        return "";
    }

    public static String getCodeByValue(String value) {
        try {
            return RolesEnum.valueOf(value).getCode();
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
