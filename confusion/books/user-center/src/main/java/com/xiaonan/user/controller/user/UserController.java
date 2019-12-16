package com.xiaonan.user.controller.user;

import com.xiaonan.user.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
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


}
