package com.xiaonan.user.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [阿波罗测试]</p>
 * Created on 2019/12/18
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Slf4j
@RestController
public class ApolloController {

	@Value("${create.name}")
	private String name;

	@GetMapping("apollo/test")
	public String testApollo() {
		return name;
	}

}
