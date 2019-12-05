package com.xiaonan.user.service.jetcache;

import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.xiaonan.user.entity.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: [jetCache演示]</p>
 * Created on 2019/12/5
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
public interface JetCacheService {

	/***
	 * <p>Description:[方法缓存]</p>
	 * Created on 2019/12/5
	 * @param userName
	 * 		根据userName缓存数据
	 * 		如果是对象可以用 #{orject.userName}
	 * @return java.util.List<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	@Cached(name = "user:method:jetCache", key = "#userName", expire = 60, cacheType = CacheType.REMOTE)
	List<User> methodJetCache(String userName);


	/***
	 * <p>Description:[自动刷新缓存]</p>
	 *	@CacheRefresh注解说明：
	 *		属性              				默认值               说明
	 *		refresh           				未定义		         刷新间隔
	 *		timeUnit          				TimeUnit.SECONDS     时间单位
	 *		stopRefreshAfterLastAccess	    未定义               指定该key多长时间没有访问就停止刷新，如果不指定会一直刷新
	 *		refreshLockTimeout              60秒                 类型为BOTH/REMOTE的缓存刷新时，同时只会有一台服务器在刷新，这台服务器会在远程缓存放置一个分布式锁，此配置指定该锁的超时时间
	 *	   单位说明
	 *     TimeUnit.DAYS          //天
	 * 	   TimeUnit.HOURS         //小时
	 * 	   TimeUnit.MINUTES       //分钟
	 * 	   TimeUnit.SECONDS       //秒
	 * 	   TimeUnit.MILLISECONDS  //毫秒
	 */
	@CacheRefresh(refresh = 10, stopRefreshAfterLastAccess = 60, timeUnit = TimeUnit.SECONDS)
	@Cached(name = "user:refres:jetCache", key = "#userName", expire = 60, cacheType = CacheType.REMOTE)
	List<User> userRefreshCache(String userName);
}
