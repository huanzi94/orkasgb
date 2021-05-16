package com.orkasgb.orkasgbweb.controller.sys;


import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.exception.GlobalException;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityAuthentication;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityMenuRight;
import com.orkasgb.orkasgbserver.server.common.CommonServer;
import com.orkasgb.orkasgbserver.server.sys.OperatorService;
import com.orkasgb.orkasgbserver.server.sys.RightService;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping(value = "/operator")
public class OperatorController extends BaseController {

    @Value("security.publicKey")
    private static String publicKey;

    @Resource
    OperatorService operatorService;

    @Resource
    RightService rightService;

    @Resource
    CommonServer commonServer;

    @AuthorityAuthentication
    @RequestMapping(value = "/getOperatorList", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo getOperatorList(@RequestBody OperatorEntity operatorEntity) throws GlobalException {
        ResultVo<List<OperatorEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        List<OperatorEntity> allOperatorList = operatorService.getOperatorList(operatorEntity);
        resultVo.setData(allOperatorList);
        return resultVo;
    }

    /**
     * 删除作员
     */
    @RequestMapping(value = "/deleteOperator", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo deleteOperator(@RequestBody OperatorEntity operatorEntity) throws GlobalException {
        ResultVo<OperatorEntity> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        operatorService.deleteOperator(operatorEntity);
        return resultVo;
    }

    /**
     * 增加菜单
     *
     * @param
     */
    @RequestMapping(value = "/addOperator", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo addOperator(@RequestBody OperatorEntity operatorEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        String operatorNo = commonServer.getNextValueByTableName("operator");
        operatorEntity.setOperatorNo(operatorNo);
        operatorService.addOperator(operatorEntity);
        return resultVo;
    }

    /**
     * 增加菜单
     *
     * @param
     */
    @RequestMapping(value = "/updateOperator", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo updateOperator(@RequestBody OperatorEntity operatorEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        operatorService.updateOperator(operatorEntity);
        return resultVo;
    }
}
