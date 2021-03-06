package com.easybcp.sys.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easybcp.sys.service.IRestTestService;
import com.easybcp.utils.BaseResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "test管理-tags", value = "test管理-value")
@RestController
@RequestMapping("/test")

public class TestController  implements IRestTestService{

	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@ApiOperation("查询用户列表")
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public BaseResponse<String> test1(@RequestParam("id") String id) {
		
		log.info(id);
		restTest(id,id);
		//throw new RuntimeException("test");
		
		
		//return new BaseResponse<String>(id);
	}
	
	@Transactional
	public void confirmRestTest(String id, String name) {
		log.info(id+"/confirmRestTest/"+name);
	}

	@Transactional
	public void cancelRestTest(String id, String name) {
		log.info(id+"/cancelRestTest/"+name);
	}

	@Transactional
	@Override
	public void restTest(String id, String name) {
		log.info(id+"/restTest/"+name);
	}


}