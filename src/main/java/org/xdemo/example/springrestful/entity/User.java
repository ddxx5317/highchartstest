/**
 * 
 */
package org.xdemo.example.springrestful.entity;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-4-2下午1:40:32
 * @描述 用户实体类
 */
public class User {
	
	private String userId;
	
	private String userName;
	
	public User(){}
	
	public User(String userId,String userName){
		this.userId=userId;
		this.userName=userName;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
