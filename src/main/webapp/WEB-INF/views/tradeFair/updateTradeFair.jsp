<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/assets/scripts/uploadify/uploadify.css">
    <script type="text/javascript" src="${ctx }/assets/scripts/uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#file_upload').uploadify({
                'swf': '${ctx }/assets/scripts/uploadify/uploadify.swf',
                'uploader': '${ctx }/rest/upload/img',
                'multi': false,// 是否支持多个文件上传
                'onUploadSuccess': function (file, data, response) {
                    $("#imgUrl").attr("value", data);
                    $("#iconImg1").attr("src", data);
                },
                'onQueueComplete': function (queueData) {
                    if (queueData.uploadsSuccessful < 1) {
                        alert('文件上传失败');
                    }
                }

                // Your options here
            });
        })
    </script>

</head>
<body>
<section class="content" style="border:none;">
    <form action="${ctx}/rest/tradeFair/update" method="post" id="dataForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${item.id}">
            <li style="display:flex;align-items:center">
                <span>类型：</span>
                <select name="tradeType" id="tradeType" class="dropdown">
                    <option value="0" <c:if test="${item.tradeType==0}">selected</c:if> >楼盘展销会</option>
                    <option value="1" <c:if test="${item.tradeType==1}">selected</c:if> >看楼团</option>
                </select>
            </li>
            <li><span>图片上传：</span>
                <div style="float: left;">
                    <input type="hidden" name="imgUrl" id="imgUrl" value="${item.imgUrl}">

                    <img style="margin-bottom: 10px;max-width:80px;max-height:80px" id="iconImg1"
                         src="${item.imgUrl}">
                    <input type="file" name="file_upload" id="file_upload"/>
                </div>
            </li>
            <li><span>楼盘ID：</span>
                <input type="text" name="housesId" id="housesId" value="${item.housesId}"/>
            </li>

            <li><span>标题：</span>
                <input type="text" name="title" id="title" value="${item.title}"/>
            </li>
            <li><span>简介：</span>
                <textarea rows="" cols="" style="width: 250px;height: 100px;border: 1px solid #dbe2e6;" name="introduction" id="introduction">${item.introduction}</textarea>
            </li>

            <li>
                <span></span>
                <a target="contentF" class="public_btn bg2" id="save" onclick="updateData()">保存</a>
            </li>
        </ul>

    </form>
</section>

<script type="text/javascript">
    //保存数据
    function updateData() {
        var data = $("#dataForm").serialize();
        $.ajax({
            type: "post",
            url: "${ctx}/rest/tradeFair/update",
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