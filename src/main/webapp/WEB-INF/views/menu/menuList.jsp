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
            <th style="width: 3%"></th>
            <th style="width: 3%">城市</th>
            <th style="width: 3%">平台</th>
            <th style="width: 3%">名称</th>
            <th style="width: 5%">点击量</th>

            <th style="width: 25%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${!empty requestScope.items }">
                <c:forEach items="${requestScope.items }" var="item"
                           varStatus="xh">
                    <tr>
                        <input type="hidden" id="id" value="${item.id}"/>
                        <td>${xh.count }</td>
                        <td>${item.city }</td>
                        <td> <c:if test="${item.source ==0 }">网站</c:if>
                            <c:if test="${item.source ==1 }">微站</c:if></td>
                        <td>${item.menuName }</td>
                        <td>${item.clickNum }</td>

                        <td>

                            <a target="contentF" onclick="edit(${item.id })">编辑</a>
                            <a target="contentF" onclick="toRedistribute(${item.id })">删除</a>
                            <a target="contentF" onclick="toRedistribute(${item.id })">隐藏</a>
                            <a target="contentF" onclick="sort(${item.id },${item.orderby},1)">上移</a>
                            <a target="contentF" onclick="sort(${item.id },${item.orderby},2)">下移</a>
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



    function edit(id){
        layer.open({
            type: 2,
            title: ['修改'],
            shade: 0.3,
            area: ['500px', '500px'],
            content: ['${ctx}/rest/user/findUser?userId='+userId+'&flag=1','no']
        });
    }
    //删除
    function sort(id,orderById,sort) {
        $.ajax({
            type: "post",
            url: "${ctx}/rest/menu/sort?sort="+sort+"&orderby="+orderById+"&id="+id,
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


    function toUpdateAppointment(appointId) {
        layer.open({
            type: 2,
            title: ['更新'],
            shade: 0.3,
            area: ['1000px', '700px'],
            content: ['${ctx}/rest/entrust/to_update?entrustId=' + appointId , 'no']
        });
    }
</script>
</body>
</html>