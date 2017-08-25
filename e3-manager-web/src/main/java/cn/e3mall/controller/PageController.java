package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 *
 */
@Controller
public class PageController {
	// 输入ip:端口 就会自动跳转到index.jsp页面
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	// 用于页面跳转
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {

		return page;
	}

}
