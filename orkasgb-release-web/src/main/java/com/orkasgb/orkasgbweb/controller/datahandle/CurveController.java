package com.orkasgb.orkasgbweb.controller.datahandle;

import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.CurveData;
import com.orkasgb.orkasgbserver.server.datahandle.DataHandleService;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping(value = "/curve")
public class CurveController extends BaseController {

    @Resource
    DataHandleService dataHandleService;

    @RequestMapping(value = "/getCurveDataList", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo<Object> getCurveDataList(@RequestBody CurveData curveData) {
        ResultVo<Object> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        Object curveDataList = dataHandleService.getCurveDataList(curveData);
        resultVo.setData(curveDataList);
        return resultVo;
    }
}
