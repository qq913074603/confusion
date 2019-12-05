package com.xiaonan.user.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.github.pagehelper.PageInfo;
import com.xiaonan.user.entity.User;
import com.xiaonan.user.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
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

	// 定义一个是String类型的远程缓存
	@CreateCache(name ="i5xforyou.username", expire = 120, cacheType = CacheType.REMOTE)
	private Cache<String, String> userNameCache;
	// 定义一个是User对象的二级缓存(本地+远程)
	@CreateCache(name ="i5xforyou.user", localExpire = 60, localLimit = 100, expire = 120, cacheType = CacheType.BOTH)
	private Cache<String, User> userCache;


	@PostMapping("/test")
	public String test() {
		userNameCache.put("name", "谢楠");
		log.info("\n 测试日志是否记录");
		return userNameCache.get("name");
	}

	/***
	 * <p>Description:[分页查询]</p>
	 * Created on 2019/12/3
	 * @param req
	 * @return com.github.pagehelper.PageInfo<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	@PostMapping("/user/pageList")
	public PageInfo<User> pageList(User req) {
		return userService.selectList(req);
	}
}
