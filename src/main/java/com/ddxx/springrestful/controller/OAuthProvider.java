package com.ddxx.springrestful.controller;

public interface OAuthProvider {

    String getOpenId(String name) throws Exception;

}
