package com.orkasgb.orkasgbserver.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "roleNo")
    private String roleNo;

    @TableField("roleType")
    private String roleType;

    @TableField("departmentNo")
    private String departmentNo;

    /**
     * 有效标志@0无效1有效
     */
    private String vaild;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;
}
