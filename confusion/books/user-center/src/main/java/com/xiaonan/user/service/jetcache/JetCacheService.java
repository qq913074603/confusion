package com.xiaonan.user.service.jetcache;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.xiaonan.user.entity.User;

import java.util.List;

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
}
