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
				<th style="width: 8%">序号</th>
				<th style="width: 8%">平台</th>
				<th style="width: 8%">模块名称</th>
				<th style="width: 8%">城市</th>
                <th style="width: 10%">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${!empty requestScope.items }">
                <c:forEach items="${requestScope.items }" var="item" varStatus="xh">
                    <tr>
						<input type="hidden" id="id" value="${item.id}"/>
						<td>${xh.count}</td>
						<td>
                            <c:if test="${item.source == '0'}">网站</c:if>
                            <c:if test="${item.source == '1'}">微站</c:if>
                        </td>
						<td>${item.modeName}</td>
						<td>${item.cityName}</td>
						<td>
                            <a class="edit_img" title="编辑" target="contentF" href="${ctx}/rest/specialPage/to_update?id=${item.id}"></a>
                            <a class="delete_img" title="删除" target="contentF" onclick="delete1(${item.id })"></a>
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
        layer.open({
            type: 1,
            skin: 'layer-style',
            area: ['350px','200px'],
            shadeClose: false, //点击遮罩关闭
            title:['删除Banner'],
            resize: false,
            scrollbar:false,
            content:
            '<section class = "content" style = "border:none; height:100%;">'+
            '<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您确定要删除当前配置吗?</p>'+
            '</section>',
            btn:['确定','取消'],
            yes: function(index){
                $.ajax({
                    type: "post",
                    url: "${ctx}/rest/specialPage/update?id="+id+"&isDelete=1",
                    cache:false,
                    async:false, // 此处必须同步
                    dataType: "json",
                    success: function(data){
                        if(data.state==0){
                            layer.msg("删除成功！",{icon:1});
                            setTimeout(function(){$("#searchForm").submit();},1000);
                        }else{
                            layer.msg("删除失败！！",{icon:7});
                        }
                        layer.close(index);
                    }
                });
            }
            ,success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.css('text-align', 'center');
            }
        });
    }

    function to_edit(id){
        layer.open({
            type: 2,
            title: ['修改'],
            shade: 0.3,
            area: ['500px', '700px'],
            content: ['${ctx}/rest/specialPage/to_update?id='+id,'no']
        });
    }


</script>
</body>
</html>