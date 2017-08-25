package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
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
	public TbItem getTbItemById(@PathVariable Long itemId) throws Exception {
		TbItem tbItem = itemService.getTbItemById(itemId);
		return tbItem;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getTbItemById(Integer page, Integer rows) throws Exception {
		//表现层得到的EasyUIDataGridResult中得到的也是page对象,但是因为web中没有page的jar包,所以会有警告.
		EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
		
		return itemList;
	}
}
