package com.xiaonan.user.service.jetcache.impl;

import com.xiaonan.user.entity.User;
import com.xiaonan.user.service.jetcache.JetCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/5
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Slf4j
@Service("jetCacheService")
public class JetCacheServiceImpl implements JetCacheService {

	@Override public List<User> methodJetCache(String userName) {
		log.info("\n 方法缓存, 开始收集数据");
		return setUser(userName);
	}

	private List<User> setUser(String userName) {
		List<User> list = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			User u = new User();
			u.setUserName(userName + i);
			u.setPersonName("admin");
			u.setPassword("123456");
			list.add(u);
		}
		return list;
	}
}
