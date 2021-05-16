package com.orkasgb.orkasgbapp.commcode;

public enum CodeInfoEnum {
    CODE_200("200", "Request successful"),
    CODE_301("301", "The resource you requested may be moved elsewhere"),
    CODE_400("400", "Wrong request"),
    CODE_401("401", "Permission error or not logged in"),
    CODE_403("403", "No access"),
    CODE_500("500", "Server internal error");

    String message;

    String code;

    CodeInfoEnum(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
