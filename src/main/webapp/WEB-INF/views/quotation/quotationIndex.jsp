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
			<p class = "detail-title">
				<a class = "setup"  target="contentF" onclick="toAddPage()">新增</a>
			</p>
		<form action="${ctx }/rest/quotation/list" method="POST" id="searchForm"
				onsubmit="submitSearchRequest('searchForm','listDiv');return false;">
			<input type="hidden" name="isNew" value="${isNew}"/>
			<ul class = "userinfo row">
				<li><span>城市：</span>
					<select name="cityId" id="cityId" class="dropdown">
						<option value="" >全部</option>
						<c:forEach items="${citys}" var="item">
						<option value="${item.id}" >${item.name}</option>
						</c:forEach>
					</select>
				</li>
				<li><span>区域：</span>
					<input type="text" name="phone" id="phone" placeholder="请输入手机号码" /></li>
				</li>
				<li><span>类型：</span>
					<select name="type" id="type" class="dropdown">
						<option value="" >全部</option>
						<c:forEach items="${types}" var="type">
							<option value="${type.id}" >${type.name}</option>
						</c:forEach>
					</select>

				</li>
				<li>
					<input class = "public_btn bg1" type="submit" name="inquery" id="inquery" value = "查询"/>
				</li>
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
                content:['${ctx}/rest/quotation/to_add', 'no']
            });
        }
		 window.onload = function(){
             $('#searchForm').submit();
		}
	</script>
	<script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
</body>
</html>