package com.xiaonan.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description: [登录实体]</p>
 * Created on 2020/1/8
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2020 北京柯莱特科技有限公司
 */
@Data
public class LoginReq{

	/**
	 * 登录名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;

}
