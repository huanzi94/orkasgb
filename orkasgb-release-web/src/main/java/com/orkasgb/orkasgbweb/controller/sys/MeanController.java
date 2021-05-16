package com.orkasgb.orkasgbweb.controller.sys;


import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.exception.GlobalException;
import com.orkasgb.orkasgbapp.utils.ExcleUtils;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.MeanuEntity;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityAuthentication;
import com.orkasgb.orkasgbserver.server.common.CommonServer;
import com.orkasgb.orkasgbserver.server.sys.MeanService;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping(value = "/meanu")
public class MeanController extends BaseController {

    @Resource
    MeanService meanService;

    @Resource
    CommonServer commonServer;

    /**
     * 增加菜单
     *
     * @return ResultVo
     */
    @RequestMapping(value = "/addMean", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo addMean(@RequestBody MeanuEntity meanuEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        // 菜单No
        String meanuNo = commonServer.getNextValueByTableName("meanu");
        meanuEntity.setMeanuNo(meanuNo);
        meanService.addMean(meanuEntity);
        return resultVo;
    }

    /**
     * 查询菜单
     *
     * @return String
     */
    @AuthorityAuthentication
    @RequestMapping(value = "/getMeanuList", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo getMeanuList(@RequestBody MeanuEntity meanuEntity) throws GlobalException {
        ResultVo<List<MeanuEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        List<MeanuEntity> mapList = meanService.getMeanuList(meanuEntity);
        resultVo.setData(mapList);
        return resultVo;
    }

    /**
     * 更新菜单
     *
     * @return ResultVo
     */
    @RequestMapping(value = "/updateMean", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo updateMean(@RequestBody MeanuEntity meanuEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        meanService.updateMean(meanuEntity);
        return resultVo;
    }

    /**
     * 删除菜单
     *
     * @return String
     */
    @RequestMapping(value = "/deleteMeanu", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo deleteMeanu(@RequestBody MeanuEntity meanuEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        meanService.deleteMeanu(meanuEntity);
        return resultVo;
    }

    /**
     * 菜单
     *
     * @return String
     */
    @RequestMapping(value = "/getMenuByOperator", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo getMenuByOperator(@RequestBody OperatorEntity operatorEntity) throws GlobalException {
        ResultVo<List<MeanuEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        operatorEntity.setOperatorNo("10028");
        String operatorNo = "10028";
        String meanuLev = this.getParameter("meanuLev");
        List<MeanuEntity> meanuEntityList = meanService.getMenuByOperator(operatorEntity, meanuLev);
        resultVo.setData(meanuEntityList);
        return resultVo;
    }

    /**
     * 查询菜单
     *
     * @return String
     */
    @RequestMapping(value = "/exportDataExcle", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8",
            produces = "application/json")
    public ResultVo exportDataExcle(@RequestBody MeanuEntity meanuEntity) throws GlobalException {
        ResultVo<List<MeanuEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        try {
            List<MeanuEntity> meanuEntityList = meanService.getMeanuList(meanuEntity);
            ExcleUtils.exportExcle(this.getResponse(), meanuEntityList, "mean");
            resultVo.setData(meanuEntityList);
        } catch (DataAccessException | NumberFormatException | IOException e) {
            resultVo.setCode(CodeEnum.FAIL.getCode());
            resultVo.setStatus(CodeEnum.FAIL.getStatus());
            resultVo.setMessage("According to the operator query information is wrong");
        }
        return resultVo;
    }
}
