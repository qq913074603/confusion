package com.xiaonan.user.entity;

import com.xiaonan.common.utlis.PageRes;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
@Data
public class User extends PageRes implements Serializable {

    private static final long serialVersionUID = 7038728005305707001L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 称呼
     */
    private String personName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 会员等级
     */
    private Integer vip;

    /**
     * 等级
     */
    private Long level;

    /**
     * 经验
     */
    private Long experience;

    /**
     * 金币数量
     */
    private Long money;

    /**
     * 砖石数量
     */
    private Long masonry;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * 1 未启用 0 启用
     */
    private Integer state;

    /**
     * 版本号 乐观锁
     */
    private Integer var;

    /**
     * 删除标识 1 删除 0 未删除
     */
    private Integer delSta;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 上次登录时间
     */
    private Date lastTime;

}