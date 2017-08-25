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
            <th style="width: 8%"></th>
            <th style="width: 10%">缩列图</th>
            <th style="width: 20%">标题</th>
            <th style="width: 15%">城市</th>
            <th style="width: 10%">点击量</th>
            <th style="width: 15%">发布日期</th>
            <th style="width: 20%">操作</th>
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
                        <td><img src="${item.imgUrl }" style="width:40px;height:40px" alt=""></td>
                        <td>${item.title }</td>
                        <td>${item.cityName }</td>
                        <td>${item.clickNum }</td>
                        <td>${item.releaseTime }</td>
                        <td>
                            <a target="contentF" onclick="to_comment(${item.id});" >评论</a>
                            <a target="contentF" href="${ctx}/rest/research/to_update?id=${item.id}">编辑</a>
                            <a target="contentF" onclick="deleteInfrmateion(${item.id })">删除</a>
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

    function deleteInfrmateion(id){
        $.ajax({
            type: "post",
            url: "${ctx}/rest/research/delete?id="+id,
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

    function to_comment(id){
        layer.open({
            type: 2,
            skin: 'layer-style',
            area: ['1000px','500px'],
            shadeClose: false, //点击遮罩关闭
            title:['评论'],
            resize: true,
            scrollbar: true,
            content:['${ctx}/rest/comment/index?informationId='+id, ]
        });

    }


</script>
</body>
</html>