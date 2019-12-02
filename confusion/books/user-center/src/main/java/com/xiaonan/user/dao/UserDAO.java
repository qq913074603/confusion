package com.xiaonan.user.dao;

import com.xiaonan.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/3
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Mapper
public interface UserDAO {

	/***
	 * <p>Description:[获取集合]</p>
	 * Created on 2019/12/3
	 * @param user
	 * @return java.util.List<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	List<User> selectList(@Param("entity") User user);

}
