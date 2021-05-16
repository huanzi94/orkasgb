package com.orkasgb.orkasgbweb.controller.sys;


import com.alibaba.fastjson.JSONObject;
import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.exception.GlobalException;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.entity.RightEntity;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityAuthentication;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityMenuRight;
import com.orkasgb.orkasgbserver.server.common.CommonServer;
import com.orkasgb.orkasgbserver.server.sys.RightService;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping(value = "/right")
@AuthorityMenuRight(url = "/right")
public class RightController extends BaseController {

    @Resource
    RightService rightService;

    @Resource
    CommonServer commonServer;

    /**
     * 增加菜单
     */
    @AuthorityAuthentication
    @RequestMapping(value = "/addRight", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo addRight(@RequestBody RightEntity rightEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        String treeData = this.getParameter("treeData");
        List<RightEntity> rightEntityList = JSONObject.parseArray(treeData, RightEntity.class);
        rightEntityList.stream().map(right -> right.setRightNo(commonServer.getNextValueByTableName("operatorRight"))).collect(Collectors.toList());
        rightService.addRight(rightEntityList);

        return resultVo;
    }

    /**
     * 增加菜单
     */
    @AuthorityAuthentication
    @RequestMapping(value = "/getRightList", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo getRightList(@RequestBody RightEntity rightEntity) throws GlobalException {
        ResultVo<List<RightEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        List<RightEntity> right = rightService.getRightList(rightEntity);
        resultVo.setData(right);

        return resultVo;
    }

    /**
     * 删除菜单
     */
    @RequestMapping(value = "/deleteRight", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo deleteRight(@RequestBody RightEntity rightEntity) throws GlobalException {
        ResultVo<OperatorEntity> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        rightService.deleteRight(rightEntity);
        return resultVo;
    }
}
