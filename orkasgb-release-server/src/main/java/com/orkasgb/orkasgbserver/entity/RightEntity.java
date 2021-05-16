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
public class RightEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "rightNo")
    private String rightNo;

    /**
     * 菜单编号
     */
    @TableField("meanuNo")
    private String meanuNo;

    /**
     * 功能描述
     */
    @TableField("rightDesc")
    private String rightDesc;

    /**
     * 备注
     */
    @TableField("rightText")
    private String rightText;

    /**
     * 有效标志
     */
    private String vaild;

    /**
     * 开始时间
     */
    @TableField("rightSTime")
    private String rightSTime;

    /**
     * 结束时间
     */
    @TableField("rightETime")
    private String rightETime;

    /**
     * 操作员
     */
    @TableField("operatorNo")
    private String operatorNo;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private String createTime;

    /**
     * 菜单树标签中的使用到的，表示是否已经有该菜单权限，在界面上对应的菜单权限不可选择
     */
    @TableField("disabled")
    private String disabled;

    /**
     * 请求地址
     */
    private String meanuUrl;
}
