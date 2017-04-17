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
<script type="text/javascript" src="../js/highcharts.js"></script>
<script type="text/javascript" src="../js/modules/exporting.js"></script>
</head>

<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height: 600px"></div>

<script type="text/javascript">
    var chart;
	$(function () {
	    $(document).ready(function() {
	        chart = new Highcharts.Chart({
	            chart: {
	                renderTo: 'container',
	                plotBackgroundColor: null,
	                plotBorderWidth: null,
	                plotShadow: false
	            },title: {
	                text: '教师绩效分析图'
	            },
	            tooltip: {
	                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	            },
	            plotOptions: {
	                pie: {
	                    allowPointSelect: true,
	                    cursor: 'pointer',
	                    dataLabels: {
	                        enabled: true,
	                        color: '#000000',
	                        connectorColor: '#000000',
	                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                    },
	                    showInLegend: true
	                }
	            },
	            series: [{
	                type: 'pie',
	                name: '所占比例',
	            }]
	        });
	    });
	      //调用查询，加载数据
	      chaxun();
	});
    function chaxun(){
        var arr = [];
        var param = $('#groupS').val();
           if($('#departmentS').val()!="全部"){
               param += "&department="+$('#departmentS').val();
           }
           if($('#typeS').val()!="全部"){
               param += "&type="+$('#typeS').val();
           }
        $.ajax({
            url:'/springrestful/highcharts/getData2',
			data:{
    	 		param1:"123",
    	 		param2:"456"
    	 	},
            type:"POST",  
            dataType: 'json', 
				success : function(data) {
					alert("into");
				    var datas= eval(data);  
					alert(datas.title);
					alert(datas.data.a1);
					$(data).each(function(index, item) {
						arr.push([ item.name, item.num ]);
					});
					chart.series[0].setData(arr);//数据填充到highcharts上面 
				},
				error : function(e) {
					alert("不好意思，请要访问的图标跑到火星去了。。。。");
				}
			});
		};
	</script>
</body>
</html>

