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
            <th style="width: 3%">委托编号</th>
            <th style="width: 3%">信息来源</th>
            <th style="width: 3%">称呼</th>
            <th style="width: 5%">电话</th>
            <th style="width: 2%">类型</th>
            <th style="width: 2%">分类</th>
            <th style="width: 5%">委托时间</th>
            <th style="width: 5%">所属区域</th>
            <th style="width: 5%">小区名</th>
            <th style="width: 5%">门牌地址</th>
            <th style="width: 5%">户型</th>
            <th style="width: 5%">面积</th>
            <th style="width: 5%">售价/租价</th>
            <th style="width: 15%">预约时间</th>
            <th style="width: 5%">经纪人</th>
            <th style="width: 5%">state</th>
            <th style="width: 5%">处理时间</th>
            <th style="width: 25%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${!empty requestScope.entrusts }">
                <c:forEach items="${requestScope.entrusts }" var="appoint"
                           varStatus="xh">
                    <tr>
                        <td>${appoint.entrustSn }</td>
                        <td> <c:if test="${appoint.source ==0 }">网站</c:if>
                            <c:if test="${appoint.source ==1 }">微站</c:if></td>
                        <td>${appoint.call }</td>
                        <td>${appoint.phone }</td>
                        <td>${appoint.houseType }</td>
                        <td>${appoint.sellRent }</td>
                        <td>${appoint.entrustTime }</td>
                        <td>${appoint.area }</td>
                        <td>${appoint.communityName }</td>
                        <td>${appoint.address }</td>
                        <td>${appoint.layout }</td>
                        <td>${appoint.measure }</td>
                        <td>${appoint.price }</td>
                        <td>${appoint.entrustTime }</td>
                        <td>${appoint.userCnName }</td>
                        <td>${appoint.status }</td>
                        <td>${appoint.handleTime }</td>
                        <td>

                            <a target="contentF" onclick="toRedistribute(${appoint.id })">重新分配经纪人</a>

                            <a target="contentF" onclick="toUpdateAppointment(${appoint.id })">修改</a>
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
    //删除
    //修改
    function toRedistribute(id) {
        layer.open({
            type: 2,
            title: ['重新分配经纪人'],
            shade: 0.3,
            area: ['1000px', '700px'],
            content: ['${ctx}/rest/entrust/toRedistribute?entrustId=' + id , 'no']
        });
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