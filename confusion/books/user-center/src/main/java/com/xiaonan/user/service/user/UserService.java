package com.xiaonan.user.service.user;

import com.xiaonan.user.entity.User;

import java.util.List;

/**
 * <p>Description: [描述]</p >
 * Created on 2019年12月03日
 *
 * @author < a href="xienan@camelotchina.com">谢楠</ a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
public interface UserService {

	/***
	 * <p>Description:[根据条件查询]</p>
	 * Created on 2019/12/16
	 * @param user
	 * @return java.util.List<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	List<User> selectListByInfo(User user);

}
