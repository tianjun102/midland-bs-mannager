<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <style type="text/css">
        .content ul.userinfo > li {
            margin-left: 0;
            padding-top: 8px;
        }

        .content ul.userinfo li > span,
        .content ul.userinfo li:not(:last-child) input,
        .content ul.userinfo ._star,
        .content ul.userinfo .dropdown {
            height: 30px !important;
            line-height: 30px !important;
            vertical-align: middle;
        }
        .content ul.userinfo li input[type=checkbox]{
            float: none;
            width: auto!important;
            height: auto!important;
            margin-right: 3px;
        }
        .peitao{
            height: 30px;line-height: 30px;
        }
        .peitao > span{padding-right: 15px;}
        .peitao > span em{vertical-align: middle;}
    </style>
</head>
<body>


<section class="content" style="border:none;">
    <form action="${ctx}/rest/appoint/update" method="post" id="appointInfoForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${entrust.id}">
            <li class="col-md-6"><span>预约编号：</span><input type="text" name="entrustSn" id="entrustSn"
                                                          value="${entrust.entrustSn}"/>
            </li>
            <li class="col-md-6"><span>委托时间：</span><input type="text" name="entrustTime" id="entrustTime"
                                                          value="${entrust.entrustTime}" maxlength="50"/><span
                    class="_star">*</span>
            </li>
            <li class="col-md-6"><span>用户：</span><input type="text" name="nickName" id="nickName"
                                                        value="${entrust.nickName}"/>
            </li>
            <li class="col-md-6"><span>手机号码：</span><input type="text" name="phone" id="phone"
                                                          value="${entrust.phone}"
                                                          maxlength="50"/><span class="_star">*</span></li>
            <li class="col-md-6"><span>分类：</span>
                <select name="sellRent" id="sellRent" class="dropdown">
                    <!-- <option value="" >请选择</option> -->
                    <option value="0"
                            <c:if test="${entrust.sellRent==0}">selected="selected"</c:if>>出售
                    </option>
                    <option value="1"
                            <c:if test="${entrust.sellRent==1}">selected="selected"</c:if>>出租
                    </option>
                </select>
                <span class="_star">*</span>
            </li>

            <li class="col-md-6"><span>委托类型：</span>
                <select name="houseType" id="houseType" class="dropdown">
                    <option value="0"
                            <c:if test="${entrust.houseType==0}">selected="selected"</c:if>>住宅
                    </option>
                    <option value="1"
                            <c:if test="${entrust.houseType==1}">selected="selected"</c:if>>公寓
                    </option>
                    <option value="2"
                            <c:if test="${entrust.houseType==2}">selected="selected"</c:if>>写字楼
                    </option>
                    <option value="3"
                            <c:if test="${entrust.houseType==3}">selected="selected"</c:if>>商铺
                    </option>
                </select>
            </li>

            <li class="col-md-6"><span>区域：</span><input type="text" name="area" id="area" value="${entrust.area}"/>
            </li>
            <li class="col-md-6"><span>小区：</span><input type="text" name="communityName" id="communityName"
                                                        value="${entrust.communityName}" maxlength="50"/><span
                    class="_star">*</span></li>
            <li class="col-md-6"><span>地址：</span><input type="text" name="address" id="address"
                                                        value="${entrust.address}"/>
            </li>
            <li class="col-md-6"><span>户型：</span><input type="text" name="layout" id="layout"
                                                        value="${entrust.layout}"/>

            </li>
            <li class="col-md-6"><span>面积：</span><input type="text" name="measure" id="measure"
                                                        value="${entrust.measure}"
                                                        maxlength="50"/><span class="_star">*</span></li>
            <li class="col-md-6"><span>装修：</span><input type="text" name="renovation" id="renovation"
                                                        value="${entrust.renovation}"/>


            </li>
            <li class="col-md-6"><span>配套：</span>
                <div class="peitao">
                    <span><input type="checkbox"><em>带家电</em></span>
                    <span><input type="checkbox"><em>宽带</em></span>
                    <span><input type="checkbox"><em>冰箱</em></span>
                    <span><input type="checkbox"><em>洗衣机</em></span>
                </div>
            </li>
            <li class="col-md-11"><span>备注：</span>
                <textarea name="remark" id="remark"
                          style="width:calc(100% - 120px);height:50px;resize:none; border: 1px solid #dbe2e6; border-radius: 4px; outline-color: #0099e0;"></textarea>
            </li>
            </li>
            <li class="col-md-11"><span>处理记录：</span>
                <textarea name="record" id="record" disabled="disabled"
                          style="width:calc(100% - 120px);height:150px;resize:none; border: 1px solid #dbe2e6; border-radius: 4px; outline-color: #0099e0;">
<c:forEach items="${entrustLogs}" var="s">
    ${s.state}
    ${s.logTime}
    ${s.operatorName}
    ${s.remark}
</c:forEach>
                </textarea></li>
            </li>
            <li class="col-md-6">
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
        var data = $("#appointInfoForm").serialize();
        debugger;
        $.ajax({
            type: "post",
            url: "${ctx}/rest/entrust/update",
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
    //检查手机号格式
    function checkPhone() {
        debugger;
        var phone0 = $("#ph").val();
        var reg = /^1[3,4,5,7,8]\d{9}$/;
        var phone = $("input[name='phone']").val();
        if (phone.trim() == '') {
            layer.tips("手机号不能为空！", "input[name='phone']", {tips: 1});
            return false;
        }
        if (!reg.test(phone)) {
            layer.tips("手机号格式有误,请核对!", "input[name='phone']", {tips: 3});
            return false;
        }
        if (phone0 == phone) {
            return true;
        }

        var a = true;
        $.ajax({
            type: "post",
            url: "${ctx }/rest/user/checkPhoneUnique",
            async: false, // 此处必须同步
            dataType: "json",
            data: {"phone": phone},
            success: function (xmlobj) {
                if (xmlobj.flag == 1) {
                    layer.tips("当前手机号码已被使用，请更换手机号码！", "input[name='phone']", {tips: 1});
                    a = false;
                } else {
                    a = true;
                }
            }
        });
        return a;
    }

    //检查邮箱格式
    function checkEmail() {
        var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
        var email = $("input[name='email']").val();
        if (email.trim() == '') {
            //layer.tips("邮箱不能为空！", "input[name='email']",{tips:3});
            return true;
        }
        if (!reg.test(email)) {
            layer.tips("邮箱格式有误,请核对!", "input[name='email']", {tips: 3});
            //$("input[name='email']").focus();
            return false;
        }
        return true;
    }

    //取消
    function closeWin() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);
    }
</script>
<script type="text/javascript" src="${ctx}/assets/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
</body>
</html>