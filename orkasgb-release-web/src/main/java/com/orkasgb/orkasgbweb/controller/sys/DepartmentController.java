package com.orkasgb.orkasgbweb.controller.sys;

import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.exception.GlobalException;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.DepartmentEntity;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.server.common.CommonServer;
import com.orkasgb.orkasgbserver.server.sys.DepartmentService;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping(value = "/department")
public class DepartmentController extends BaseController {

    @Resource
    DepartmentService departmentService;

    @Resource
    CommonServer commonServer;

    /**
     * 增加菜单
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo addDepartment(@RequestBody DepartmentEntity departmentEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        // 菜单No
        String departmentNo = commonServer.getNextValueByTableName("department");
        departmentEntity.setDepartmentNo(departmentNo);
        departmentService.addDepartment(departmentEntity);

        return resultVo;
    }

    /**
     * 增加菜单
     */
    @RequestMapping(value = "/getDepartment", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo getDepartment(@RequestBody DepartmentEntity departmentEntity) throws GlobalException {
        ResultVo<List<DepartmentEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        List<DepartmentEntity> department = departmentService.getDepartment(departmentEntity);
        resultVo.setData(department);
        return resultVo;
    }

    /**
     * 删除菜单
     */
    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo deleteDepartment(@RequestBody DepartmentEntity departmentEntity) throws GlobalException {
        ResultVo<OperatorEntity> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        departmentService.deleteDepartment(departmentEntity);
        return resultVo;
    }
}
