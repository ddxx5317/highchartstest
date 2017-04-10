package com.ddxx.springrestful.controller;
import org.springframework.stereotype.Service;

@Service
@OAuthService(name = "WeChatProvider")
public class WeChatProvider implements OAuthProvider {

	@Override
	public String getOpenId(String value) throws Exception {
		return  value+":"+"WeChat.URL";
	}

}
