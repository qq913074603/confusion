package com.xiaonan.user.controller.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2020/1/7
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2020 北京柯莱特科技有限公司
 */
@Controller
public class RedirctController {

	@GetMapping("/login")
	public String login() {
		return "page/login-2";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

//	@GetMapping("")
//	public String redirctUrl() {
//		return "login1";
//	}

}
