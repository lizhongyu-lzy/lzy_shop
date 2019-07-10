package com.lzy.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ShopServiceImplTest {

	@Resource 
	ShopService service;
	@Test
	public void test() {
		
		Map map = new HashMap();
		map.put("tid", new String[] {"1","2"});
		List list = service.getList(map);
		System.out.println(list);
	}

}
