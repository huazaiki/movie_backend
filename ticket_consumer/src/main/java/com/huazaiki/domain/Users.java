package com.huazaiki.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    /**
     * 用户ID
     */
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
}