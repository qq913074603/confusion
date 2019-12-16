package com.xiaonan.user.commons;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Data
public class Page {

	/***
	 * <p>Description:[起始页]</p>
	 * Created on 2019/12/16
	 * @param null
	 * @return
	 * @author 谢楠
	 */
	@TableField(exist = false)
	private Integer currentPage = 1;

	/***
	 * <p>Description:[每页条数]</p>
	 * Created on 2019/12/16
	 * @param null
	 * @return
	 * @author 谢楠
	 */
	@TableField(exist = false)
	private Integer pageSize = 10;


}
