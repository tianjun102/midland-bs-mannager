<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
    </script>

</head>
<body>
<section class="content" style="border:none;">
    <form action="${ctx}/rest/specialPage/update" method="post" id="dataForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${item.id}">
            <li><span>cityId：</span>
               <input type="text" name="cityId" id="cityId" value="${item.cityId}"/>
            </li>
            <li><span>source：</span>
               <input type="text" name="source" id="source" value="${item.source}"/>
            </li>
            <li><span>modeName：</span>
               <input type="text" name="modeName" id="modeName" value="${item.modeName}"/>
            </li>
            <li><span>position：</span>
               <input type="text" name="position" id="position" value="${item.position}"/>
            </li>
            <li><span>title：</span>
               <input type="text" name="title" id="title" value="${item.title}"/>
            </li>
            <li><span>description：</span>
               <input type="text" name="description" id="description" value="${item.description}"/>
            </li>
            <li><span>price：</span>
               <input type="text" name="price" id="price" value="${item.price}"/>
            </li>
            <li><span>address：</span>
               <input type="text" name="address" id="address" value="${item.address}"/>
            </li>
            <li><span>imgUrl：</span>
               <input type="text" name="imgUrl" id="imgUrl" value="${item.imgUrl}"/>
            </li>
            <li><span>subwayDistance：</span>
               <input type="text" name="subwayDistance" id="subwayDistance" value="${item.subwayDistance}"/>
            </li>
            <li><span>linkUrl：</span>
               <input type="text" name="linkUrl" id="linkUrl" value="${item.linkUrl}"/>
            </li>
            <li><span>detail：</span>
               <input type="text" name="detail" id="detail" value="${item.detail}"/>
            </li>
            <li><span>isDelete：</span>
               <input type="text" name="isDelete" id="isDelete" value="${item.isDelete}"/>
            </li>
            <li>
                <span></span>
                <a target="contentF" class="public_btn bg2" id="save" onclick="updateData()">更新</a>
                <a style="margin-left: 20px" class="public_btn bg3" id="cancel" onclick="closeWin();">取消</a>
            </li>
        </ul>

    </form>
</section>

<script type="text/javascript">
    //保存数据
    function updateData() {
        var data = $("#dataForm").serialize();
        debugger;
        $.ajax({
            type: "post",
            url: "${ctx}/rest/specialPage/update",
            async: false, // 此处必须同步
            dataType: "json",
            data: data,
            success: function (data) {
                if (data.state == 0) {
                    layer.msg("保存成功！！！", {icon: 1});
                    $('#save').removeAttr("onclick");
                    setTimeout(function () {
                        parent.location.reload();
                    }, 1000);

                } else {
                    layer.msg("保存失败！", {icon: 2});
                }
            },
            error: function () {
                layer.msg("保存失败！", {icon: 2});
            }
        });
    }

    //取消
    function closeWin() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);
    }
</script>
</body>
</html>