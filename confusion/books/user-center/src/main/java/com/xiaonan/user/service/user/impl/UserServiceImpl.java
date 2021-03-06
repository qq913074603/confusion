package com.xiaonan.user.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaonan.user.dao.UserDAO;
import com.xiaonan.user.entity.User;
import com.xiaonan.user.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/3
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;

	@Override public List<User> selectListByInfo(User user) {
		// 参数构造
		QueryWrapper<User> wr = new QueryWrapper<>();
		if (null != user) {
			wr.like("user_name", user.getUserName());
		}
		return userDAO.selectList(wr);
	}
}
