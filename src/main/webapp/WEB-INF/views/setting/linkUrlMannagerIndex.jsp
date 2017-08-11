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
				<span>友情链接管理</span>
				<a class = "setup"  target="contentF" onclick="toAddPage()">添加</a>
			</p>
		<form action="${ctx}/rest/setting/showlinkUrlList" method="POST" id="searchForm"
				onsubmit="submitSearchRequest('searchForm','listDiv');return false;">
			<ul class = "userinfo row">
				<li>
					<span style = "float:left;">城市：</span>
					<select name="cityId" id="cityId" style="height: 38px;width: 150px; display: inline-table;border-radius: 4px;border: 1px solid #dbe2e6;">
						<option value="">全部</option>
						<c:forEach items="${cityList}" var="city">
						<option value="${city.id}">${city.name}</option>
						</c:forEach>
					</select>
				</li>

				<li>
					<span style = "float:left;">平台：</span>
					<select name="source" id="source" class="dropdown">
						<option value="">全部</option>
						<option value="1">网站</option>
						<option value="2">微站</option>
					</select>
				</li>
				<li><input class = "public_btn bg1" type="submit" name="inquery" id="inquery" value = "查询"/></li>
			</ul>
			</form>
			<div id="listDiv"></div>
		</section>
	</div>
	
	
	<script type="text/javascript">
		/* $(function(){
			$('#searchForm').submit();
		}); */
		 window.onload = function(){
             $('#searchForm').submit();
		}

		function toAddPage(){
			layer.open({
				type: 2,
				skin: 'layer-style',
				area: ['500px','600px'],
				shadeClose: false, //点击遮罩关闭
				title:['新建友情链接'],
				resize: false,
				scrollbar:false,
				content:['${ctx}/rest/setting/toAddLinkUrlPage', 'no']
			});
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