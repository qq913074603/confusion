package com.xiaonan.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaonan.user.entity.User;
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
public interface UserDAO extends BaseMapper<User> {

	/***
	 * <p>Description:[获取集合]</p>
	 * Created on 2019/12/3
	 * @param user
	 * @return java.util.List<com.xiaonan.user.entity.User>
	 * @author 谢楠
	 */
	List<User> selectListBy(@Param("entity") User user);

}
