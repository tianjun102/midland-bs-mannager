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
    <form action="${ctx}/rest/quotation/add" method="post" id="dataForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${item.id}">
            <li><span>dataTime：</span>
               <input type="text" name="dataTime" id="dataTime" value="${item.menuName}"/>
            </li>
            <li><span>type：</span>
               <input type="text" name="type" id="type" value="${item.menuName}"/>
            </li>
            <li><span>cityId：</span>
               <input type="text" name="cityId" id="cityId" value="${item.menuName}"/>
            </li>
            <li><span>areaId：</span>
               <input type="text" name="areaId" id="areaId" value="${item.menuName}"/>
            </li>
            <li><span>sliceId：</span>
               <input type="text" name="sliceId" id="sliceId" value="${item.menuName}"/>
            </li>
            <li><span>dealNum：</span>
               <input type="text" name="dealNum" id="dealNum" value="${item.menuName}"/>
            </li>
            <li><span>dealAcreage：</span>
               <input type="text" name="dealAcreage" id="dealAcreage" value="${item.menuName}"/>
            </li>
            <li><span>price：</span>
               <input type="text" name="price" id="price" value="${item.menuName}"/>
            </li>
            <li><span>soldNum：</span>
               <input type="text" name="soldNum" id="soldNum" value="${item.menuName}"/>
            </li>
            <li><span>soldArea：</span>
               <input type="text" name="soldArea" id="soldArea" value="${item.menuName}"/>
            </li>
            <li><span>ringRatio：</span>
               <input type="text" name="ringRatio" id="ringRatio" value="${item.menuName}"/>
            </li>
            <li><span>updateTime：</span>
               <input type="text" name="updateTime" id="updateTime" value="${item.menuName}"/>
            </li>
            <li><span>isNew：</span>
               <input type="text" name="isNew" id="isNew" value="${item.menuName}"/>
            </li>
            <li><span>isDelete：</span>
               <input type="text" name="isDelete" id="isDelete" value="${item.menuName}"/>
            </li>
            <li><span>cityName：</span>
               <input type="text" name="cityName" id="cityName" value="${item.menuName}"/>
            </li>
            <li><span>areaName：</span>
               <input type="text" name="areaName" id="areaName" value="${item.menuName}"/>
            </li>
            <li><span>sliceName：</span>
               <input type="text" name="sliceName" id="sliceName" value="${item.menuName}"/>
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
            url: "${ctx}/rest/quotation/add",
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