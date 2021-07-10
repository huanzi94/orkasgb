package com.orkasgb.orkasgbserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CurveData {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 数据类型
     */
    @TableId(value = "dataType")
    private String dataType;

    /**
     * 数据名称
     */
    @TableId(value = "dataName")
    private String dataName;

    /**
     * 数据值
     */
    @TableId(value = "value")
    private String value;

    /**
     * 时间
     */
    @TableId(value = "time")
    private String time;
}
