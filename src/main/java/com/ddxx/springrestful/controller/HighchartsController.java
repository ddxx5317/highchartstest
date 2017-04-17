package com.ddxx.springrestful.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

  
/** 
 * @author lyx 
 *   
 * 2015-6-12下午1:36:51 
 * 
 *springechart.com.controller.echartsContr 
 */  
@Controller  
@RequestMapping("/highcharts")  
public class HighchartsController {  
	
	@RequestMapping("/index")
	public String test() throws Exception {
		System.out.println("index");
		return "user/hc";
	}
	
    @RequestMapping("getData")
    @ResponseBody
    public Map<String,Object> getData(String department, String group,String param1,String param2,String type){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title", "High Charts Demo");
        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("department", department);
        param.put("group", group);
        param.put("type", type);
        
        //数据
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("a1", "a1");
        data.put("a2", "a2");
        data.put("a3", "a3");
        data.put("a4", "a4");
        data.put("a5", "a5");
        list.add(data);
        map.put("data",list);
        return map;
    }
    @RequestMapping("getData2")
    @ResponseBody
    public String getData2(String department, String group,String param1,String param2,String type){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title", "High Charts Demo");
        
        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("department", department);
        param.put("group", group);
        param.put("type", type);
        
        //数据
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("a1", "a1");
        data.put("a2", "a2");
        data.put("a3", "a3");
        data.put("a4", "a4");
        data.put("a5", "a5");
        list.add(data);
        map.put("data",list);
        return  JSON.toJSONString(map);
    }
}  