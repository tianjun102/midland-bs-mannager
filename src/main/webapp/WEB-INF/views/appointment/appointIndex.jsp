<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${ctx }/assets/css/bootstrap.min.css">

<link rel="stylesheet" href="${ctx }/assets/css/easydropdown.css" />
<link rel="stylesheet" href="${ctx }/assets/css/common.css">

</head>
<body>
	
	
	<!--用户列表界面-->
	<div class="box"> 
		<section class = "content">
			<p class = "detail-title">
				<span>看房记录列表</span>
				<a class = "setup"  target="contentF" onclick="toAddPage()">创建用户</a>
			</p>
		<form action="${ctx }/rest/appoint/page" method="POST" id="searchForm"
				onsubmit="submitSearchRequest('searchForm','listDiv');return false;">
			<ul class = "userinfo row">
				<li><span>小区名：</span><input type="text" name="communityName" id="communityName" placeholder="请输入小区" /></li>
				<li><span>手机号码：</span><input type="text" name="phone" id="phone" placeholder="请输入手机号码" /></li>
				<li>
					<span>分类：</span>
					<select name="sellRent" id="sellRent" class="dropdown">
						<option value="">全部</option>
						<c:forEach items="${sellRents}" var="s" >
							<option value="${s.id}">
									${s.name}
							</option>
						</c:forEach>
					</select>
				</li>
				<li><span>state：</span>
					<select name="status" id="status" class="dropdown">
						<option value="">全部</option>
						<c:forEach items="${statusList}" var="s1" >
							<option value="${s1.id}">
									${s1.name}
							</option>
						</c:forEach>
					</select>
				</li>
				<li><span>来源：</span>
					<select name="source" id="source" class="dropdown">
						<option value="">全部</option>
						<c:forEach items="${sources}" var="s1" >
							<option value="${s1.id}">
									${s1.name}
							</option>
						</c:forEach>
					</select>
				</li>
				<li><span>预约时间</span><input class="Wdate half" id="time1"
										onFocus="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'time2\')}'})"
										name="startTime" /> <em class = "gang">-</em><input
						class="Wdate half"
						onFocus="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'time1\')}'})"
						id="time2" name="endTime" /></li>

				<li><input class = "public_btn bg1" type="submit" name="inquery" id="inquery" value = "查询"/></li>
			</ul>
			</form>
			<div id="listDiv"></div>
		</section>
	</div>
	
	
	<script type="text/javascript">

		 window.onload = function(){
             $('#searchForm').submit();
		}

	</script>
	<!-- 本页私有js -->
	
	
	<script type="text/javascript" src="${ctx}/assets/scripts/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/scripts/jquery.easydropdown.js" ></script>
	<script type="text/javascript" src="${ctx}/assets/scripts/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
	<script type="text/javascript" src="${ctx}/assets/scripts/common.js"></script>
	<script type="text/javascript" src="${ctx}/assets/scripts/base.js" ></script>
	<script src="${ctx}/assets/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</body>
</html>