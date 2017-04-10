package com.ddxx.springrestful.controller;

import org.springframework.stereotype.Service;

@Service
@OAuthService(name = "QQProvider")
public class QQProvider implements OAuthProvider {

	@Override
	public String getOpenId(String value) throws Exception {
		return value+":"+"QQ.URL";
	}

}
