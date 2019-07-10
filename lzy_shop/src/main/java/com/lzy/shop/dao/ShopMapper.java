package com.lzy.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lzy.shop.domain.Shop;
import com.lzy.shop.domain.Type;

/**
 * @author Administrator
 *
 */
public interface ShopMapper {
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	List getList(Map map);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	List getType();
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	void addCenter(@Param("sid")Integer sid, @Param("tid")Integer i);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	void addShop(Shop shop);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	Shop getShop(Integer sid);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	List getTypeCha(Integer sid);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	void delShop(String sid);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	void delCenter(String sid);
}
