package com.xiaonan.utils;

import com.alibaba.fastjson.JSON;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/2
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
public class StrUtlis {

	public static void sout(Object o){
		System.out.println("\n 输出内容:" + JSON.toJSONString(o));
	}

}
