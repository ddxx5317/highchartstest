package com.ddxx.springrestful.controller;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;

@Service("oauthProviderFactory")
public class DefaultOAuthProviderFactory implements OAuthProviderFactory ,ApplicationContextAware{
	
	ApplicationContext applicationContext = null;
	
    private Map<String, Object> oAuthProviderMap = new ConcurrentHashMap<String, Object>();

	@SuppressWarnings("unchecked")
	@Override
	public <T extends OAuthProvider> T createOAuthProvider(String name) {
		return (T) oAuthProviderMap.get(name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		registerOAuthService();
	}
	
	 private void registerOAuthService() {
		  Map<String, Object> oAuthServiceMap = applicationContext.getBeansWithAnnotation(OAuthService.class);
		  for(Map.Entry<String, Object> obj : oAuthServiceMap.entrySet()){
			  String oauthProviderName = getOAuthServiceName(obj.getValue());
			 if(!StringUtils.isEmpty(oauthProviderName)){
				 oAuthProviderMap.put(oauthProviderName, obj.getValue());
			 }
		  }
	 }
	 
	 private String getOAuthServiceName(Object bean) {
	        if (bean != null) {
	            Annotation annotation = AnnotationUtils.getAnnotation(bean.getClass(), OAuthService.class);
	            if (annotation != null) {
	                return (String) AnnotationUtils.getValue(annotation, "name");
	            }
	        }
	        return "";
	    }
}
