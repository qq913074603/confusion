package com.xiaonan.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaonan.user.entity.ZhuangbeiInfo;
import com.xiaonan.user.service.zhuangbei.ZhuangbeiInfoService;
import com.xiaonan.utils.StrUtlis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: [装备测试]</p>
 * Created on 2019/12/16
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2019 北京柯莱特科技有限公司
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhuangbeiInfoTest {

	@Resource
	private ZhuangbeiInfoService zhuangbeiInfoService;

	@Test
	public void selectPageList() {
		ZhuangbeiInfo info = new ZhuangbeiInfo();
		info.setPageSize(100);
		IPage<ZhuangbeiInfo> zhuangbeiInfoIPage = zhuangbeiInfoService.selectPageList(info);
		StrUtlis.sout(zhuangbeiInfoIPage);
		List<ZhuangbeiInfo> records = zhuangbeiInfoIPage.getRecords();
		records.forEach(zhuang -> System.out.println("---数据----" + JSON.toJSONString(zhuang)));
	}

}
