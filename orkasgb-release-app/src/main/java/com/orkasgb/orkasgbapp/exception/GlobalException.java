package com.orkasgb.orkasgbapp.exception;

import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.commcode.CodeInfoEnum;
import com.orkasgb.orkasgbapp.utils.I18nUtils;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Objects;

@ControllerAdvice
public class GlobalException extends Throwable {

    @ResponseBody
    @ExceptionHandler
    public ResultVo<Object> exceptionHandle(Exception e, HttpServletRequest request, HttpServletResponse response) {
        ResultVo<Object> resultVo = new ResultVo<>(CodeEnum.FAIL.getStatus(), "");

        if (e instanceof NotPermissionException || e instanceof NotRoleException) {
            resultVo.setMessage(CodeInfoEnum.CODE_401.getMessage());
            resultVo.setCode(CodeInfoEnum.CODE_401.getCode());
        } else if (e instanceof DataAccessException || e instanceof SQLException) {
            resultVo.setMessage(CodeInfoEnum.CODE_500.getMessage());
            resultVo.setCode(CodeInfoEnum.CODE_500.getCode());
        } else if (e instanceof MethodArgumentNotValidException) {
            String messageKey = Objects.requireNonNull(((MethodArgumentNotValidException) e).getFieldError()).getDefaultMessage();
            String field = Objects.requireNonNull(((MethodArgumentNotValidException) e).getFieldError()).getField();
            resultVo.setMessage(String.format(I18nUtils.getMessage(messageKey), field));
            resultVo.setCode(CodeInfoEnum.CODE_400.getCode());
        } else {
            resultVo.setMessage(CodeInfoEnum.CODE_500.getMessage());
            resultVo.setCode(CodeInfoEnum.CODE_500.getCode());
        }
        return resultVo;
    }
}
