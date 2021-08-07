package com.orkasgb.orkasgbserver.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "not.null")
    @NotBlank(message = "not.null")
    @NotEmpty(message = "not.null")
    private String roleNo;

    @TableField("roleType")
    private String roleType;

    @TableField("operatorNo")
    private String operatorNo;

    /**
     * 有效标志@0无效1有效
     */
    @TableField("vaild")
    private String vaild;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;
}
