package com.lzy.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzy.shop.dao.ShopMapper;
import com.lzy.shop.domain.Shop;
import com.lzy.shop.domain.Type;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopMapper mapper;
	
	public List getList(Map map) {
		// TODO Auto-generated method stub
		return mapper.getList(map);
	}

	public List getType() {
		// TODO Auto-generated method stub
		return mapper.getType();
	}

	@Override
	public void add(Shop shop, Integer[] tid) {
		mapper.addShop(shop);
		if(tid != null) {
			for (Integer i : tid) {
				mapper.addCenter(shop.getSid(),i);
				
			}
		}
		
	}

	@Override
	public Shop getShop(Integer sid) {
		// TODO Auto-generated method stub
		return mapper.getShop(sid);
	}

	@Override
	public List getTypeCha(Integer sid) {
		// TODO Auto-generated method stub
		return mapper.getTypeCha(sid);
	}

	@Override
	public void del(String sid) {
		mapper.delShop(sid);
		mapper.delCenter(sid);
		
	}

}
