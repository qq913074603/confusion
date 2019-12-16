package com.xiaonan.user.entity;

import com.xiaonan.user.commons.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Data
public class ZhuangbeiInfo extends Page implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * attrib
	 */
	private Integer attrib;

	/**
	 * 佩戴位置
	 */
	private Integer amount;

	/**
	 * 外观
	 */
	private Integer type;

	/**
	 * 装备名字
	 */
	private String str;

	/**
	 * 颜色
	 */
	private String quality;

	/**
	 * 佩戴限制
	 */
	private Integer master;

	/**
	 * 金木水火土
	 */
	private Integer metal;

	/**
	 * 伤害
	 */
	private Integer mana;

	/**
	 * 伤害
	 */
	private Integer accurate;

	/**
	 * 气血
	 */
	private Integer def;

	/**
	 * 法力
	 */
	private Integer dex;

	/**
	 * 防御
	 */
	private Integer wiz;

	/**
	 * 速度
	 */
	private Integer parry;

	/**
	 * 创建时间
	 */
	private Date addTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 逻辑删除
	 */
	private boolean deleted;

	public ZhuangbeiInfo() {
	}

}
