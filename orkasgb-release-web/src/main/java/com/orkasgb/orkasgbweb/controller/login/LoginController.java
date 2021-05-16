package com.orkasgb.orkasgbweb.controller.login;


import cn.dev33.satoken.stp.StpUtil;
import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.exception.GlobalException;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.server.login.LoginServer;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("login")
public class LoginController extends BaseController {

    @Resource
    LoginServer loginServer;

    /**
     * 登录校验
     *
     * @return String
     */
    @RequestMapping(value = "/loginValidate", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo loginValidate(@RequestBody OperatorEntity operatorEntity) throws GlobalException {
        ResultVo<OperatorEntity> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        OperatorEntity operator = loginServer.loginValidate(operatorEntity);
        if (Objects.isNull(operator)) {
            resultVo.setCode(CodeEnum.FAIL.getCode());
            resultVo.setStatus(CodeEnum.FAIL.getStatus());
            resultVo.setMessage("Account or password is error");
            return resultVo;
        }
        // 保存登录信息
        StpUtil.setLoginId(operator.getOperatorLoginId(), Boolean.valueOf(this.getParameter("rememberMe")));
        this.getResponse().setHeader(StpUtil.getTokenName(), StpUtil.getTokenValue());
        this.getResponse().setHeader("Access-Control-Expose-Headers", StpUtil.getTokenName());
        resultVo.setData(operator);
        return resultVo;
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo loginOut() throws GlobalException {
        ResultVo<OperatorEntity> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        StpUtil.logout();
        return resultVo;
    }
}

