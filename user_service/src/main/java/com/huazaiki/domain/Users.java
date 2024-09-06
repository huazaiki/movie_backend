package com.huazaiki.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class Users implements Serializable {
    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 电话号码
     */
    private String userPhone;

    /**
     * 0普通会员 1管理员
     */
    private Integer isAdmin;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}