/**
 * 
 */
package com.ddxx.springrestful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddxx.springrestful.entity.User;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-4-2下午1:28:07
 */
@Controller
@RequestMapping("/user")
public class UserController {

	public List<User> list = null;

	/**
	 * user路径下默认显示用户列表
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		if (list == null) {
			list = getUserList();
		}
		ModelMap model = new ModelMap();
		model.addAttribute("list", list);

		return new ModelAndView("user/index", model);
	}

	/**
	 * 跳转到添加用户页面，约定优于配置，默认匹配文件/WEB-INF/views/user/add.jsp
	 */
	@RequestMapping("add")
	public void add() {
	}

	/**
	 * 新增保存用户
	 * 
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		if (list == null) {
			list = getUserList();
		}
		list.add(user);

		ModelMap model = new ModelMap();
		model.addAttribute("list", list);

		return new ModelAndView("user/index", model);
	}

	/**
	 * 查看用户详细信息
	 * 
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ModelAndView viewUser(@PathVariable("id") String id) {
		User user = findUserById(id);
		ModelMap model = new ModelMap();
		model.addAttribute("user", user);

		return new ModelAndView("user/view", model);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public String deleteUser(@PathVariable("id") String id) {
		if (list == null) {
			list = getUserList();
		}
		removeUserByUserId(id);
		return "suc";
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping("{id}/edit")
	public ModelAndView toEdit(@PathVariable("id") String id) {

		User user = findUserById(id);
		ModelMap model = new ModelMap();
		model.addAttribute("user", user);

		return new ModelAndView("user/edit", model);
	}

	/**
	 * 更新用户并跳转到用户列表页面
	 * 
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView edit(User user) {
		updateUser(user);
		return new ModelAndView("redirect:/user/");
	}

	/**
	 * 造10个用户
	 * 
	 * @return List<User>
	 */
	private List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			list.add(new User((i + 1) + "", "李四" + (i + 1)));
		}
		return list;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return List<User>
	 */
	private List<User> removeUserByUserId(String id) {
		if (list == null)
			return null;
		for (User user : list) {
			if (user.getUserId().equals(id)) {
				list.remove(user);
				break;
			}
		}
		return list;
	}

	/**
	 * 查找用户
	 * 
	 * @param id
	 * @return User
	 */
	private User findUserById(String id) {
		User user = null;
		if (list == null)
			return null;
		for (User _user : list) {
			if (_user.getUserId().equals(id)) {
				user = _user;
				break;
			}
		}
		return user;
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	private void updateUser(User user) {
		for (User _user : list) {
			if (_user.getUserId().equals(user.getUserId())) {
				_user.setUserName(user.getUserName());
				break;
			}
		}
	}
}
