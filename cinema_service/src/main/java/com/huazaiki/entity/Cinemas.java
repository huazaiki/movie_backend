package com.huazaiki.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName cinemas
 */
@TableName(value ="cinemas")
@Data
public class Cinemas implements Serializable {
    /**
     * 影院ID
     */
    @TableId(type = IdType.AUTO)
    private Integer cinId;

    /**
     * 影院名称
     */
    private String cinName;

    /**
     * 影院地址
     */
    private String cinAddress;

    /**
     * 联系电话
     */
    private String cinPhone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}