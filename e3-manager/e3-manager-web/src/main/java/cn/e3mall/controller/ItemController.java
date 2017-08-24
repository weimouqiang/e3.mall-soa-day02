package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	// 注入interface包中的service接口
	@Autowired
	private ItemService itemService;
	
	// 使用restFul风格写代码
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getTbItemById(@PathVariable long itemId) throws Exception {
		TbItem tbItem = itemService.getTbItemById(itemId);
		return tbItem;
	}

}
