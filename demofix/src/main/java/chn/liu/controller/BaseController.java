package chn.liu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	
	// 把spring data的page进行转换，变成easyui需要的数据
	public <T> Map<String, Object> findEasyUIData(Page<T> page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", page.getContent());
		map.put("total", page.getTotalElements());
		return map;
	}
}
