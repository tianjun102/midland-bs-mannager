<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>美联物业 - 关于平台</title>
<link rel="stylesheet" href="${ctx }/assets/css/common.css">

</head>
<body>
<!--关于平台界面-->
	<div class="box" style = "width:auto;">
		<section class = "content" style = "width:auto;">
			<p class = "detail-title">
				<span>预览新房行情</span>
			</p>
			<dl>
			<dt style = "font-size:28px; color:#d20000; margin-top:45px; margin-bottom:30px; text-align:center;">预览新房行情</dt>
			<dt style = "text-align:center;">
				<div class = "canva" id="main" style="width: 90%;height:600px;text-align: center;" ></div>
			</dt>
			</dl>
		</section>
	</div>
${month}
</body>
</html>

<script type="text/javascript">
    var array1;
    var myChart = echarts.init(document.getElementById('main'));


    options = {
        title: {
            text: '折柱混合'
        },

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#ffffff'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['一手房','二手房','平均价格']
        },
        xAxis: [
            {
                type: 'category',
                data: ${month},
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '价格',
                min: 0,
                max: 70000,
                interval:5000,
                axisLabel: {
                    formatter: '{value} 元'
                }
            },
            {
                type: 'value',
                name: '价格',
                min: 0,
                max: 70000,
                interval: 5000,
                axisLabel: {
                    formatter: '{value} 元'
                }
            }
        ],
        series: [
            {
                name:'价格',
                type:'bar',
                data:${data},
				barWidth:'20',
				itemStyle:{
                    normal:{
                        color:'#b6a2de',
						barBorderRadius:[6,6,6,6]
                    }
                }
            },
            {
                name:'均价',
                type:'line',
                yAxisIndex: 1,
                smooth: true,
                symbolSize: 7,
                data:${data},
                itemStyle:{
                    normal:{
                        color:'#2ec7c9'
                    }
                }
            }
        ]
    };

    myChart.setOption(options);

</script>
