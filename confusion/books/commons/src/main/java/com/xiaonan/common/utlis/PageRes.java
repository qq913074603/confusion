package com.xiaonan.common.utlis;

import lombok.Data;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/3
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Data
public class PageRes {

	/**
	 * 起始页
	 */
	private Integer pageNum;

	/**
	 * 每页条数
	 */
	private Integer pageSize;
}
