package com.orkasgb.orkasgbapp.commcode;

public enum CodeEnum {
    FAIL("fail", "403"),
    SUCCESS("success", "200");

    String status;

    String code;

    CodeEnum(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
