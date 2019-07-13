package com.example.demo.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private RedisClient redisClient;
	
	@RequestMapping("/set")
	@ResponseBody
	public void set(String key, String value) throws Exception {
		redisClient.set(key, value);
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public String get(String key) throws Exception {
		return redisClient.get(key);
	}
}
