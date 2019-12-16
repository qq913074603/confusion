package com.xiaonan.user.service.zhuangbei;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaonan.user.entity.ZhuangbeiInfo;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
public interface ZhuangbeiInfoService {

	/***
	 * <p>Description:[分页查询]</p>
	 * Created on 2019/12/16
	 * @param info
	 * @return com.baomidou.mybatisplus.core.metadata.IPage<com.xiaonan.user.entity.ZhuangbeiInfo>
	 * @author 谢楠
	 */
	IPage<ZhuangbeiInfo> selectPageList(ZhuangbeiInfo info);

}
