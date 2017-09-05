package cn.e3mall.item.listener;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 用于监听商品变化的监听器
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class ItemChangeListener implements MessageListener {

	@Autowired
	private ItemService itemService;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Value("${html.gen.path}")
	private String htmlGenPath;

	@Override
	public void onMessage(Message message) {
		try {
			// 1、商品添加后发送一个商品添加消息topic
			// 2、在e3-item-web工程中订阅消息
			// 3、从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			long itemId = Long.parseLong(text);
			// 4、根据商品id查询商品基本信息和商品描述
			Thread.sleep(2000);
			// 根据商品id取商品基本信息
			TbItem tbItem = itemService.getTbItemById(itemId);
			Item item = new Item(tbItem);
			// 取商品描述
			TbItemDesc itemDesc = itemService.itemDescById(itemId);
			// 5、把商品信息封装到map中。
			Map data = new HashMap<>();
			data.put("item", item);
			data.put("itemDesc", itemDesc);
			// 6、创建一个商品详情页面的freemarker模板，可以根据jsp改造为freemarker的模板。
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			// 7、加载模板文件，生成模板对象
			Template template = configuration.getTemplate("item.ftl");
			// 8、指定生成文件的路径及文件名。文件名就是"商品id+.html"
			Writer out = new FileWriter(htmlGenPath + itemId + ".html");
			template.process(data, out);
			// 9、关闭流
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
