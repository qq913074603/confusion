package com.xiaonan.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: [MyBatisPlus物理分页插件]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Configuration
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}
}
