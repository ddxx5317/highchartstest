/**
 * 
 */
package com.ddxx.springrestful.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddxx.springrestful.entity.User;


@Controller
@RequestMapping("/test")
public class TestController {

	public List<User> list = null;
	
	 @Resource(name = "oauthProviderFactory")
	OAuthProviderFactory oAuthProviderFactory = null;

	@RequestMapping("/test")
	public String test() throws Exception {
		 OAuthProvider oAuthProvider = oAuthProviderFactory.createOAuthProvider("QQProvider");
		 System.out.println(oAuthProvider.getOpenId("hello"));
		return "user/test";
	}
}
