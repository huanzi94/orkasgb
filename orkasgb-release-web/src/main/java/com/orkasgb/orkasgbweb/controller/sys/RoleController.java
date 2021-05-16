package com.orkasgb.orkasgbweb.controller.sys;

import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.exception.GlobalException;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import com.orkasgb.orkasgbserver.entity.OperatorEntity;
import com.orkasgb.orkasgbserver.entity.RoleEntity;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityAuthentication;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityMenuRight;
import com.orkasgb.orkasgbserver.server.common.CommonServer;
import com.orkasgb.orkasgbserver.server.sys.RoleService;
import com.orkasgb.orkasgbweb.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Resource
    RoleService roleService;

    @Resource
    CommonServer commonServer;

    /**
     * 增加菜单
     */
    @AuthorityAuthentication
    @RequestMapping(value = "/addRole", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo addRole(@RequestBody RoleEntity roleEntity) throws GlobalException {
        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
        // 菜单No
        String roleNo = commonServer.getNextValueByTableName("role");
        roleEntity.setRoleNo(roleNo);
        roleService.addRole(roleEntity);
        return resultVo;
    }

    /**
     * 增加菜单
     */
    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo getRoleList(@RequestBody RoleEntity roleEntity) throws GlobalException {
        ResultVo<List<RoleEntity>> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode(), "");
        List<RoleEntity> role = roleService.getRoleList(roleEntity);
        resultVo.setData(role);

        return resultVo;
    }

    /**
     * 删除菜单
     */
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8",
            produces = "application/json")
    public ResultVo deleteRole(@RequestBody RoleEntity roleEntity) throws GlobalException {
        ResultVo<OperatorEntity> resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode(), "");
        roleService.deleteRole(roleEntity);

        return resultVo;
    }
}
