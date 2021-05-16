package com.orkasgb.orkasgbserver.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
public class MeanuEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "meanuNo", type = IdType.AUTO)
    private String meanuNo;

    /**
     * 级别
     */
    @TableField("meanuLev")
    private String meanuLev;

    /**
     * 请求地址
     */
    @TableField("meanuUrl")
    private String meanuUrl;

    /**
     * 有效标志
     */
    @TableField("vaild")
    private String vaild;

    /**
     * 备注
     */
    @TableField("meanuText")
    private String meanuText;

    /**
     * 上级菜单编号
     */
    @TableField("meanuParentNo")
    private String meanuParentNo;

    /**
     * 名称
     */
    @TableField("meanuName")
    private String meanuName;

    /**
     * 描述
     */
    @TableField("meanuDesc")
    private String meanuDesc;

    /**
     * 菜单图标
     */
    @TableField("meanuIcon")
    private String meanuIcon;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private String createTime;

    /**
     * 组件名称
     */
    @TableField("name")
    private String name;

    /**
     * 菜单组件
     */
    @TableField("component")
    private String component;

    /**
     * 组件路径
     */
    @TableField("path")
    private String path;

    /**
     * 子菜单
     */
    private List<MeanuEntity> children;

    /**
     * 菜单树标签ID
     */
    private String id;

    /**
     * 菜单树标签名称
     */
    private String label;

    /**
     * 菜单树标签，表示是否已经有该菜单权限，取决于operatorRight表中的disabled
     */
    private String disabled;

    private String meanuParentName;
}
