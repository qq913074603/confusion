package com.xiaonan.user.controller.user;

import com.xiaonan.common.Result;
import com.xiaonan.model.LoginReq;
import com.xiaonan.user.entity.User;
import com.xiaonan.user.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/2
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Slf4j
@RestController
public class UserController {

	@Resource
	private UserService userService;

	@PostMapping("/sys/login")
	public Result login(LoginReq loginReq){
		if (null == loginReq) {
			return Result.error("账号信息不能为空");
		}
		if (StringUtils.isBlank(loginReq.getUserName())
				|| StringUtils.isBlank(loginReq.getPassword()) ) {
			return Result.error("用户密码不能为空");
		}
		if (loginReq.getUserName().equals("admin")
				&& loginReq.getPassword().equals("123456")) {
			return Result.success();
		}
		return Result.error("账号密码错误");
	}
}
