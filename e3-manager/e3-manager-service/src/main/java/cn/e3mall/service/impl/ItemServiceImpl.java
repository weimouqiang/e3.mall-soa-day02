package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem getTbItemById(long itemId) {
		// 根据主键查询
		// TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		// 根据条件进行查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andIdEqualTo(itemId);
		// 执行查询
		List<TbItem> ItemList = tbItemMapper.selectByExample(example);
		if (null != ItemList && ItemList.size() > 0) {
			TbItem tbItem = ItemList.get(0);
			return tbItem;
		}
		return null;
	}

}
