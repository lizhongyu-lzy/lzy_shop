package com.lzy.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.shop.domain.Shop;
import com.lzy.shop.domain.Type;
import com.lzy.shop.service.ShopService;
import com.lzy.shop.utils.PageUtil;

@Controller
public class ShopController {

	@Autowired
	private ShopService service;
	
	@RequestMapping("list")
	public String getList(@RequestParam(defaultValue = "" )String[] tid,
			@RequestParam(defaultValue = "" )String sname,
			Model model,
			@RequestParam(defaultValue = "1" )Integer page
			) {
		
		Map map = new HashMap();
		map.put("sname", sname);
		map.put("tid", tid);
		Integer pageSize = 3 ;
		PageHelper.startPage(page, pageSize);
		List list = service.getList(map);
		PageInfo info = new PageInfo(list);
		String pageInfo = PageUtil.page(page, info.getPages(), "/list", pageSize);
		model.addAttribute("map",map);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		List list2 = service.getType();
		model.addAttribute("list2", list2);
		return "list";
	}
	@RequestMapping("toadd")
	public String toadd(Model model) {
		
		List list = service.getType();
		
		model.addAttribute("list", list);
		return "add";
	}
	@ResponseBody
	@RequestMapping("add")
	public boolean toadd(Shop shop,Integer[] tid) {
		try {
			service.add(shop,tid);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	@ResponseBody
	@RequestMapping("del")
	public boolean del(String sid) {
		try {
			service.del(sid);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	@RequestMapping("cha")
	public String cha(Integer sid,Model model) {
		Shop shop = service.getShop(sid);
		List type = service.getTypeCha(sid);
		List list = service.getType();
		System.out.println("agaergaergaerg"+type);
		model.addAttribute("shop",shop);
		model.addAttribute("type",type);
		model.addAttribute("list",list);
		return "cha";
	}
}
