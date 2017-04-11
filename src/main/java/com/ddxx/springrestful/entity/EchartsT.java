package com.ddxx.springrestful.entity;
import com.github.abel533.echarts.Option;  
import com.github.abel533.echarts.axis.CategoryAxis;  
import com.github.abel533.echarts.axis.ValueAxis;  
import com.github.abel533.echarts.code.LineType;  
import com.github.abel533.echarts.code.Magic;  
import com.github.abel533.echarts.code.MarkType;  
import com.github.abel533.echarts.code.Orient;  
import com.github.abel533.echarts.code.PointerType;  
import com.github.abel533.echarts.code.Tool;  
import com.github.abel533.echarts.code.Trigger;  
import com.github.abel533.echarts.code.X;  
import com.github.abel533.echarts.code.Y;  
import com.github.abel533.echarts.data.PointData;  
import com.github.abel533.echarts.feature.MagicType;  
import com.github.abel533.echarts.series.Bar;  
import com.github.abel533.echarts.style.LineStyle;  
  
/** 
 * @author lyx 
 *   
 * 2015-6-12下午1,34,50 
 * 
 *springechart.com.service.EchartsT 
 */  
public class EchartsT {  
   
      
    /** 
     * @return 
     * 堆积图 
     */  
    public Option stackChart()  
    {
    	Option option = new Option();
    	
    	//标题
    	option.title("获取信息途径所占比重");
    	//提示框
    	option.tooltip().trigger(Trigger.axis);
    	option.tooltip().axisPointer().type(PointerType.shadow);
    	//图例说明
    	option.legend().data("直接访问","邮件营销","联盟广告","视频广告","搜索引擎","百度","谷歌","必应","其他");
    	//工具栏
    	option.toolbox().show(true).orient(Orient.vertical).x(X.right).y(Y.center)
    	.feature(Tool.mark,Tool.dataView,Tool.dataZoom,new MagicType(Magic.bar,Magic.line,Magic.stack,Magic.tiled),
    			Tool.restore,Tool.saveAsImage);
    	
    	//是否启用拖拽重计算特性
    	option.calculable(true);
    	
    	//x轴 -类目轴
    	option.xAxis(new CategoryAxis().data("周一","周二","周三","周四","周五","周六","周日"));
    	//Y轴 -值轴
    	option.yAxis(new ValueAxis());
    	
    	//系列 ,其中stack表示堆栈图的设置
    	Bar bar1 = new Bar("直接访问");
    	bar1.data(320, 332, 301, 334, 390, 330, 320);
    	
    	Bar bar2 = new Bar("邮件营销");
    	bar2.stack("广告");
    	bar2.data(120, 132, 101, 134, 90, 230, 210);
    	
    	Bar bar3 = new Bar("联盟广告");
    	bar3.stack("广告");
    	bar3.data(220, 182, 191, 234, 290, 330, 310);
    	
    	Bar bar4 = new Bar("视频广告");
    	bar4.stack("广告");
    	bar4.data(150, 232, 201, 154, 190, 330, 410);
    	
    	Bar bar5 = new Bar("搜索引擎");
    	bar5.data(862, 1018, 964, 1026, 1679, 1600, 1570);
    	//标记线
    	bar5.markLine().itemStyle().normal().lineStyle(new LineStyle().type(LineType.dashed));
        bar5.markLine().data(new PointData().type(MarkType.min),new PointData().type(MarkType.max));
    	
    	Bar bar6 = new Bar("百度");
    	bar6.stack("搜索引擎");
    	bar6.data(620, 732, 701, 734, 1090, 1130, 1120);
    	
    	Bar bar7 = new Bar("谷歌");
    	bar7.stack("搜索引擎");
    	bar7.data(120, 132, 101, 134, 290, 230, 220);
    	
     	Bar bar8 = new Bar("必应");
    	bar8.stack("搜索引擎");
    	bar8.data(60, 72, 71, 74, 190, 130, 110);
    	
    	Bar bar9 = new Bar("其他");
    	bar9.stack("搜索引擎");
    	bar9.data(62, 82, 91, 84, 109, 110, 120);
    	
    	//添加到系列中
    	option.series(bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar9);

    	return option;
    }  
}