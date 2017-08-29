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
    <form action="${ctx}/rest/pageConf/update" method="post" id="dataForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${item.id}">
            <li><span>cityId：</span>
               <input type="text" name="cityId" id="cityId" value="${item.cityId}"/>
            </li>
            <li><span>cityName：</span>
               <input type="text" name="cityName" id="cityName" value="${item.cityName}"/>
            </li>
            <li><span>model：</span>
               <input type="text" name="model" id="model" value="${item.model}"/>
            </li>
            <li><span>metaLable：</span>
               <input type="text" name="metaLable" id="metaLable" value="${item.metaLable}"/>
            </li>
            <li><span>metaShow：</span>
               <input type="text" name="metaShow" id="metaShow" value="${item.metaShow}"/>
            </li>
            <li><span>baiduCode：</span>
               <input type="text" name="baiduCode" id="baiduCode" value="${item.baiduCode}"/>
            </li>
            <li><span>baiduShow：</span>
               <input type="text" name="baiduShow" id="baiduShow" value="${item.baiduShow}"/>
            </li>
            <li><span>cnzzCode：</span>
               <input type="text" name="cnzzCode" id="cnzzCode" value="${item.cnzzCode}"/>
            </li>
            <li><span>cnzzCodeWechat：</span>
               <input type="text" name="cnzzCodeWechat" id="cnzzCodeWechat" value="${item.cnzzCodeWechat}"/>
            </li>
            <li><span>baiduCodeWechat：</span>
               <input type="text" name="baiduCodeWechat" id="baiduCodeWechat" value="${item.baiduCodeWechat}"/>
            </li>
            <li><span>metaDesc：</span>
               <input type="text" name="metaDesc" id="metaDesc" value="${item.metaDesc}"/>
            </li>
            <li><span>title：</span>
               <input type="text" name="title" id="title" value="${item.title}"/>
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
            url: "${ctx}/rest/pageConf/update",
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