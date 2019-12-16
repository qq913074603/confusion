package com.xiaonan.user;

import com.xiaonan.user.entity.User;
import com.xiaonan.user.service.user.UserService;
import com.xiaonan.utils.StrUtlis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: [用户单元测试]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Resource
	private UserService userService;

	/***
	 * <p>Description:[单元测试]</p>
	 * Created on 2019/12/16
	 * @param
	 * @return void
	 * @author 谢楠
	 */
	@Test
	public void selectList() {
		User user = new User();
		user.setUserName("ad");
		List<User> users = userService.selectListByInfo(user);
		StrUtlis.sout(users);
	}

}
