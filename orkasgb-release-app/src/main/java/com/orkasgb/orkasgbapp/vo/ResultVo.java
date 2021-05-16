package com.orkasgb.orkasgbapp.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    private String status;

    private String code;

    private String message;

    private T data;

    public ResultVo() {
    }

    public ResultVo(String status, String code) {
        this.status = status;
        this.code = code;
        this.message = "Request successful";
    }

    public ResultVo(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ResultVo(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
