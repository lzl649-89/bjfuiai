package chn.liu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HelloWorldController {
	
	@ApiOperation(value="mvcmock测试1", httpMethod="GET", notes="用于springboot模拟springmvc测试")
	@RequestMapping("/hello1")
	public String hello1() {
		return "Hello World111";
	}
	
	@ApiOperation(value="mvcmock测试2", httpMethod="GET", notes="用于springboot模拟springmvc测试")
	@RequestMapping("/hello2")
	public List<String> hello2() {
		return Arrays.asList(new String[] {"A", "B", "C"});
	}

}
