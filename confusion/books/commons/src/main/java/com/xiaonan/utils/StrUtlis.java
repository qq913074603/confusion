package com.xiaonan.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/2
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
public class StrUtlis {

	public static void sout(String str){
		System.out.println("\n 输出内容:" + str);
	}

	public static void main(String[] args) {
		String xienan = SecureUtil.md5("xienan");
		System.out.println(xienan);
	}
}
