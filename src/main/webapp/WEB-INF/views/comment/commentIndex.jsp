<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	
	<!--列表界面-->
	<div class="box"> 
		<section class = "content">
		<form action="${ctx }/rest/comment/list" method="POST" id="searchForm"
				onsubmit="submitSearchRequest('searchForm','listDiv');return false;">
			<input type="hidden" name="informationId" value="${comment.informationId}">
			<li><span>城市：</span>
				<p>${information.cityName}</p>
			</li>
			<li><span>标题：</span>
				<p>${information.title}</p>
			</li>
			<li><span>发布时间：</span>
				<p>${information.releaseTime}</p>
			</li>
			<ul class = "userinfo row">
				<%--<li><span>select：</span>
					<select name="cityId" id="cityId" class="dropdown">
						<option value="" >全部</option>
						<c:forEach items="${citys}" var="item">
						<option value="${item.id}" >${item.name}</option>
						</c:forEach>
					</select>
				<li><span>手机号码：</span>
					<input type="text" name="phone" id="phone" placeholder="请输入手机号码" /></li>
				</li>--%>
				<%--<li><input class = "public_btn bg1" type="submit" name="inquery" id="inquery" value = "查询"/></li>--%>
			</ul>
			</form>
			<div id="listDiv"></div>
		</section>
	</div>
	
	
	<script type="text/javascript">
        function toAddPage(){
            layer.open({
                type: 2,
                skin: 'layer-style',
                area: ['500px','700px'],
                shadeClose: false, //点击遮罩关闭
                title:['新增'],
                resize: false,
                scrollbar:false,
                content:['${ctx}/rest/comment/to_add', 'no']
            });
        }
		 window.onload = function(){
             $('#searchForm').submit();
		}
	</script>
	<script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
</body>
</html>