<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<%@include file="../layout/.jsp" %>
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
    <form action="${ctx}/rest/quotation/update" method="post" id="dataForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${item.id}">
            <li><span>数据时间：</span>
                <input class="Wdate half" id="time1" onFocus="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
                                        name="dataTime" value="${item.dataTime}" style="
    width: 250px;
"/>
            </li>
            <li><span>类型：</span>
                <select name="type" id="type" class="dropdown">
                    <option value="" >全部</option>
                    <c:forEach items="${types}" var="type">
                    <option value="${type.id}" <c:if test="${type.id==item.type}">selected</c:if> >${type.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li><span>城市：</span>
               <input type="text" name="cityId" id="cityId" value="${item.cityId}"/>
            </li>
            <li><span>区域：</span>
               <input type="text" name="areaId" id="areaId" value="${item.areaId}"/>
            </li>
            <li><span>片区：</span>
               <input type="text" name="sliceId" id="sliceId" value="${item.sliceId}"/>
            </li>
            <li><span>成交套数：</span>
               <input type="text" name="dealNum" id="dealNum" value="${item.dealNum}"/>
            </li>
            <li><span>成交面积：</span>
               <input type="text" name="dealAcreage" id="dealAcreage" value="${item.dealAcreage}"/>
            </li>
            <li><span>成交均价：</span>
               <input type="text" name="price" id="price" value="${item.price}"/>
            </li>
            <li><span>可售套数：</span>
               <input type="text" name="soldNum" id="soldNum" value="${item.soldNum}"/>
            </li>
            <li><span>可售面积：</span>
               <input type="text" name="soldArea" id="soldArea" value="${item.soldArea}"/>
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
            url: "${ctx}/rest/quotation/update",
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