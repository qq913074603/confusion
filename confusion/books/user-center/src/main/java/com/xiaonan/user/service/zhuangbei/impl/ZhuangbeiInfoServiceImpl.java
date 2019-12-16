package com.xiaonan.user.service.zhuangbei.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaonan.user.dao.ZhuangbeiInfoDAO;
import com.xiaonan.user.entity.ZhuangbeiInfo;
import com.xiaonan.user.service.zhuangbei.ZhuangbeiInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@Service("zhuangbeiInfoService")
public class ZhuangbeiInfoServiceImpl implements ZhuangbeiInfoService {

	@Resource
	private ZhuangbeiInfoDAO zhuangbeiInfoDAO;

	@Override public IPage<ZhuangbeiInfo> selectPageList(ZhuangbeiInfo info) {
		// 分页查询
		QueryWrapper<ZhuangbeiInfo> query = new QueryWrapper<>();
		if (null != info) {
			// 参数
			if (StringUtils.isNotBlank(info.getStr())) {
				query.like("str", info.getStr());
			}
		}
		Page page = new Page(info.getCurrentPage(), info.getPageSize());
		IPage<ZhuangbeiInfo> userIPage = zhuangbeiInfoDAO.selectPage(page, query);
		return userIPage;
	}
}
