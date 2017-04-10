package com.ddxx.springrestful.controller;

public interface OAuthProviderFactory {

	<T extends OAuthProvider> T createOAuthProvider(String name);
}
