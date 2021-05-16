package com.orkasgb.orkasgbapp.exception;

import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.commcode.CodeInfoEnum;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalException extends Throwable {

    @ResponseBody
    @ExceptionHandler
    public ResultVo exceptionHandle(Exception e, HttpServletRequest request, HttpServletResponse response) {
        ResultVo resultVo = new ResultVo<>(CodeEnum.FAIL.getStatus(), "");

        if (e instanceof NotPermissionException || e instanceof NotRoleException) {
            resultVo.setMessage(CodeInfoEnum.CODE_401.getMessage());
            resultVo.setCode(CodeInfoEnum.CODE_401.getCode());
        } else if (e instanceof DataAccessException || e instanceof SQLException) {
            resultVo.setMessage(CodeInfoEnum.CODE_500.getMessage());
            resultVo.setCode(CodeInfoEnum.CODE_500.getCode());
        } else {
            resultVo.setMessage(CodeInfoEnum.CODE_500.getMessage());
            resultVo.setCode(CodeInfoEnum.CODE_500.getCode());
        }
        return resultVo;
    }
}
