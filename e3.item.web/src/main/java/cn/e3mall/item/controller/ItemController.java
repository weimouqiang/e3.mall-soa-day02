package cn.e3mall.item.controller;

/**
 * 显示商品详情页面
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	/**
	 * 这是通过redis缓存来提高效率
	 */
	@RequestMapping(value = "/item/{itemId}")
	public String showItemDetail(@PathVariable Long itemId, Model model) {
		// 根据商品ID查找商品,然后回显到页面
		TbItem tbItem = itemService.getTbItemById(itemId);
		Item item = new Item(tbItem);
		TbItemDesc itemDesc = itemService.itemDescById(itemId);
		model.addAttribute("itemDesc", itemDesc);
		model.addAttribute("item", item);
		return "item";
	}
	
	/**
	 * 通过FreeMarker静态页面返回数据
	 */
	
	
	
	
	
	
	
}
