package com.orkasgb.orkasgbapp.commcode.commenum;

public enum OperationsEnum {
    USER_DELETE("USER_DELETE"),
    USER_UPDATE("USER_UPDATE"),
    USER_QUERY("USER_QUERY"),
    USER_INSERT("USER_INSERT"),
    ALL("ALL");

    String value;

    OperationsEnum(String value) {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
