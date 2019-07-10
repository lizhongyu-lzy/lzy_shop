package com.lzy.shop.service;

import java.util.List;
import java.util.Map;

import com.lzy.shop.domain.Shop;
import com.lzy.shop.domain.Type;

public interface ShopService {

List getList(Map map);
	
	List getType();

	void add(Shop shop, Integer[] tid);

	Shop getShop(Integer sid);

	List getTypeCha(Integer sid);

	void del(String sid);
}
