package com.huazaiki.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName movies
 */
@TableName(value ="movies")
@Data
public class Movies implements Serializable {
    /**
     * 电影ID
     */
    @TableId(type = IdType.AUTO)
    private Integer movId;

    /**
     * 电影标题
     */
    private String movTitle;

    /**
     * 电影简介
     */
    private String movDescription;

    /**
     * 导演
     */
    private String movDirector;

    /**
     * 时长（分钟）
     */
    private Integer movDuration;

    /**
     * 评分（10分制）
     */
    private BigDecimal movRating;

    /**
     * 上映日期
     */
    private Date movReleaseDate;

    /**
     * 图片
     */
    private String movImage;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}