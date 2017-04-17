/**
 * 
 */
package com.ddxx.springrestful.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddxx.springrestful.entity.User;


@Controller
@RequestMapping("/test")
public class TestController {

	public List<User> list = null;

	@RequestMapping("/test")
	public String test() throws Exception {
		 System.out.println("ok");
		return "user/test";
	}
}
