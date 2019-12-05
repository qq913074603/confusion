package com.xiaonan.user.controller.test;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.xiaonan.common.Result;
import com.xiaonan.user.entity.User;
import com.xiaonan.user.service.jetcache.JetCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: [jetCache缓存式样]</p>
 * Created on 2019/12/5
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Slf4j
@RestController
public class JetCacheController {

	@Resource
	private JetCacheService jetCacheService;

	/**
	 * 主要参数说明
	 * name (可以为空) key值的前缀
	 * expire (可为空) 过期时间, 默认100秒
	 * cacheType (可为空) 默认是远程缓存
	 * 			缓存的类型，包括
	 * 			CacheType.REMOTE、远程缓存, redis
	 * 			CacheType.LOCAL、 本地缓存, 存在内存中
	 * 			CacheType.BOTH。如果定义为BOTH，会使用LOCAL和REMOTE组合成两级缓存
	 * localLimit (可为空)
	 * 			如果cacheType为CacheType.LOCAL或CacheType.BOTH
	 * 			这个参数指定本地缓存的最大元素数量
	 *			以控制内存占用。注解上没有定义的时候会使用全局配置，如果此时全局配置也没有定义，则取100
	 */

	/**
	 * 远程缓存
	 */
	@CreateCache(name = "user:remote:jetCache", expire = 60, cacheType = CacheType.REMOTE)
	private Cache<String, User> userRemoteCache;

	/**
	 * 本地缓存
	 */
	@CreateCache(name = "user:local:jetCache", expire = 120, cacheType = CacheType.LOCAL, localLimit = 50)
	private Cache<String, User> userLocalCache;

	/**
	 * 二级缓存, 同时缓存远程本地
	 */
	@CreateCache(name = "user:both:jetCache", expire = 120, cacheType = CacheType.BOTH, localLimit = 50)
	private Cache<String, User> userBothCache;

	/***
	 * <p>Description:[远程缓存]</p>
	 * Created on 2019/12/5
	 * @param userName
	 * @return com.xiaonan.common.Result<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	@PostMapping("cache/remoteJetCache")
	public Result<User> remoteJetCache(String userName) {
		User user = userRemoteCache.get(userName);
		if (null == user) {
			log.info("\n 远程缓存失效, 重新获取, userName = {}", userName);
			user = setUser(userName);
			userRemoteCache.put(userName, user);
			return Result.success(user);
		}
		log.info("\n 远程缓存, 获取, userName = {}", userName);
		return Result.success(user);
	}

	/***
	 * <p>Description:[本地缓存]</p>
	 * Created on 2019/12/5
	 * @param userName
	 * @return com.xiaonan.common.Result<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	@PostMapping("cache/localJetCache")
	public Result<User> localJetCache(String userName) {
		User user = userLocalCache.get(userName);
		if (null == user) {
			log.info("\n 本地缓存失效, 重新获取, userName = {}", userName);
			user = setUser(userName);
			userLocalCache.put(userName, user);
			return Result.success(user);
		}
		log.info("\n 本地缓存, 获取, userName = {}", userName);
		return Result.success(user);
	}

	/***
	 * <p>Description:[二级缓存]</p>
	 * Created on 2019/12/5
	 * @param userName
	 * @return com.xiaonan.common.Result<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	@PostMapping("cache/bothJetCache")
	public Result<User> bothJetCache(String userName) {
		User user = userBothCache.get(userName);
		if (null == user) {
			log.info("\n 二级缓存失效, 重新获取, userName = {}", userName);
			user = setUser(userName);
			userBothCache.put(userName, user);
			return Result.success(user);
		}
		log.info("\n 二级缓存, 获取, userName = {}", userName);
		return Result.success(user);
	}

	/***
	 * <p>Description:[方法缓存]</p>
	 * Created on 2019/12/5
	 * @param userName
	 * @return com.xiaonan.common.Result<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	@PostMapping("cache/methodJetCache")
	public Result<List<User>> methodJetCache(String userName) {
		log.info("\n 进入方法缓存");
		return Result.success(jetCacheService.methodJetCache(userName));
	}


	/***
	 * <p>Description:[自动刷新缓存]</p>
	 *
	 *       具体看jetCacheService
	 *
	 * Created on 2019/12/5
	 * @param userName
	 * @return com.xiaonan.common.Result<java.util.List < com.xiaonan.user.entity.User>>
	 * @author 谢楠
	 */
	@PostMapping("cache/cacheRefresh")
	public Result<List<User>> cacheUserRefresh(String userName) {
		log.info("\n 进入方法缓存");
		return Result.success(jetCacheService.userRefreshCache(userName));
	}


	private User setUser(String userName) {
		User u = new User();
		u.setUserName(userName);
		u.setPersonName("admin");
		u.setPassword("123456");
		u.setCreateTime(new Date());
		return u;
	}
}
