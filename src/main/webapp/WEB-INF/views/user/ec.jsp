<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户详情页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>  
<script type="text/javascript" src="../js/echarts.js"></script>   
</head>
  
<body>  
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->  
    <div id="main" style="height:600px"></div>  
   
 <span style="white-space:pre">   </span>
     
<script type="text/javascript">  
    require.config({  
        paths:{  
           echarts: '../js'  
       }  
    });  

    //获得后台传过来的JSON数据  
    var opt =${option};  
    //设置主要样式  
    require(  
        [ //需要什么图形就加载什么图形 这里只用到了柱状图，只需加载bar就行  
            'echarts',    
            'echarts/chart/bar',//柱状图  
            'echarts/chart/line', //折线  
            'echarts/chart/pie', //椭圆  
            'echarts/chart/map', //地图  
            'echarts/chart/funnel' //漏斗  
        ],  
        function(ec){   
            //初始化echart对象  
            var chart =ec.init(document.getElementById('main'));//ec.init( $("#main"));  
            chart.setOption(opt);  
              
       });  
</script>  
</body>  
</html>  