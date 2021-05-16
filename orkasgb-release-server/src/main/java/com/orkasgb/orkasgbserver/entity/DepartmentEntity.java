package com.orkasgb.orkasgbserver.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "departmentNo", type = IdType.AUTO)
    private String departmentNo;

    /**
     * 名称
     */
    @TableField("departmentName")
    private String departmentName;

    /**
     * 有效标志@0无效1有效
     */
    private String vaild;

    /**
     * 开始时间
     */
    @TableField("departmentSTime")
    private String departmentSTime;

    /**
     * 结束时间
     */
    @TableField("departmentETime")
    private String departmentETime;

    /**
     * 描述
     */
    @TableField("departmentDesc")
    private String departmentDesc;

    /**
     * 备注
     */
    @TableField("departmentText")
    private String departmentText;


}
