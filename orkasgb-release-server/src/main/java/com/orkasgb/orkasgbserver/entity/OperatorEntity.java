package com.orkasgb.orkasgbserver.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2021-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OperatorEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "operatorNo")
    private String operatorNo;

    /**
     * 姓名
     */
    @TableField("operatorName")
    private String operatorName;

    /**
     * 登陆账号
     */
    @TableField("operatorLoginId")
    private String operatorLoginId;

    /**
     * 登陆密码
     */
    @TableField("operatorPwd")
    private String operatorPwd;

    /**
     * 性别@0男1女
     */
    @TableField("operatorSex")
    private String operatorSex;

    /**
     * 联系电话
     */
    @TableField("operatorTel")
    private String operatorTel;

    /**
     * 有效标志@0无效1有效
     */
    private String vaild;

    /**
     * 头像
     */
    @TableField("operatorImg")
    private String operatorImg;

    /**
     * 备注
     */
    @TableField("operatorText")
    private String operatorText;

    /**
     * 建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String createTime;

    /**
     * 开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String operatorSTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String operatorETime;

    /**
     * 部门编号
     */
    @TableField("departmentNo")
    private String departmentNo;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 角色编号
     */
    @TableField("roleNo")
    private String roleNo;

    /**
     * 角色名称
     */
    private String roleName;
}
