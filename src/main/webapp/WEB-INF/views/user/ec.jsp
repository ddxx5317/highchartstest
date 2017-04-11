<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
  <script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
  </head>

<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:600px"></div>

    <!-- ECharts单文件引入 -->
    <!--  <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>  --> 

 	 <script type="text/javascript" src="../js/echarts.js"></script> 
   
   <!-- <script type="text/javascript" src="js/echarts-all.js"></script> -->
    <script type="text/javascript">

    //路径配置
    	require.config({
    		paths:{
	    		 echarts: '../js'
	    		}
    	});
  
    	//获得后台传过来的JSON数据
    	var opt =${option};
    	//设置主要样式
    	require(
	    	[
	    		'echarts',	
	    		'echarts/chart/bar',
	    		'echarts/chart/line',
	    		'echarts/chart/pie',
	    		'echarts/chart/map',
	    		'echarts/chart/funnel'
	    	],
	    	function(ec){ 
	    		//初始化echart对象
	    		var chart =ec.init(document.getElementById('main'));//ec.init( $("#main"));

			   	chart.setOption(opt);
			   	
			  	 });
                      
   
   
    </script>
    
   
</body>
</html>
