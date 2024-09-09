package com.huazaiki.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName schedules
 */
@TableName(value ="schedules")
@Data
public class Schedules implements Serializable {
    /**
     * 排片ID
     */
    @TableId(type = IdType.AUTO)
    private Integer schId;

    /**
     * 电影ID
     */
    private Integer schMovieId;

    /**
     * 影院ID
     */
    private Integer schCinemaId;

    /**
     * 放映时间
     */
    private Date schShowTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}