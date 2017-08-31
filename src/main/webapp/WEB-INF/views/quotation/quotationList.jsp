<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>


<div class="table-responsive m40">
    <table class="table table-bordered table-add">
        <thead>
            <tr>
				<th style="width: 8%">城市</th>
				<th style="width: 8%">区域</th>
				<th style="width: 8%">类型</th>
				<th style="width: 8%">成交套数</th>
				<th style="width: 8%">成交面积</th>
				<th style="width: 8%">成交均价</th>
				<th style="width: 8%">可售套数</th>
				<th style="width: 8%">可售面积</th>
				<th style="width: 8%">数据时间</th>
				<th style="width: 8%">更新时间</th>
                <th style="width: 10%">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${!empty requestScope.items }">
                <c:forEach items="${requestScope.items }" var="item" varStatus="xh">
                    <tr>
						<input type="hidden" id="id" value="${item.id}"/>
						<td>${item.cityName}</td>
						<td>${item.areaName}</td>
						<td><c:forEach items="${types}" var="s">
                            <c:if test="${item.type == s.id}" >${s.name}</c:if>
                        </c:forEach></td>
						<td>${item.dealNum}</td>
						<td>${item.dealAcreage}</td>
						<td>${item.price}</td>
						<td>${item.soldNum}</td>
						<td>${item.soldArea}</td>
						<td>${item.dataTime}</td>
						<td>${item.updateTime}</td>
						<td>
                            <a target="contentF" onclick="to_edit(${item.id })">编辑</a>
                            <a target="contentF" onclick="delete1(${item.id })">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="14">没有找到数据!</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>
<!-- 分页 -->
<c:if test="${!empty paginator}">
    <c:set var="paginator" value="${paginator}"/>
    <c:set var="target" value="listDiv"/>
    <%@include file="../layout/pagination.jsp" %>
</c:if>

<script type="text/javascript">

    function delete1(id){
        $.ajax({
            type: "post",
            url: "${ctx}/rest/quotation/update?id="+id+"&isDelete=1",
            async: false, // 此处必须同步
            dataType: "json",

            success: function (data) {
                if (data.state==0){
                    $('#searchForm').submit();
                }
            },
            error: function () {
                layer.msg("操作失败！", {icon: 2});
            }
        })
    }

    function to_edit(id){
        layer.open({
            type: 2,
            title: ['修改'],
            shade: 0.3,
            area: ['500px','700px'],
            content: ['${ctx}/rest/quotation/to_update?id='+id,'no']
        });
    }


</script>
</body>
</html>