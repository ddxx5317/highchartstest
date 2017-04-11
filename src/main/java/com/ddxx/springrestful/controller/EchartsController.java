package com.ddxx.springrestful.controller;
import javax.servlet.http.HttpServletRequest;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.alibaba.fastjson.JSON;
import com.ddxx.springrestful.entity.EchartsT;
import com.github.abel533.echarts.Option;  

  
/** 
 * @author lyx 
 *   
 * 2015-6-12下午1:36:51 
 * 
 *springechart.com.controller.echartsContr 
 */  
@Controller  
@RequestMapping("/echarts")  
public class EchartsController {  
      
    EchartsT ech = new EchartsT();  
    /** 
     * @param res 
     * @return 
     *  
     * 堆栈图 
     */  
    @RequestMapping("/stackChart")  
    public String stackChart(HttpServletRequest res)  
    {  
        Option option = ech.stackChart();
          
        String opt = JSON.toJSONString(option);  
          
        res.setAttribute("option", opt);  
          
        return "user/ec";  
    }  
}  