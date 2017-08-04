<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${ctx }/assets/css/common.css">

</head>
<body>
<section class="content" style="border:none;">
    <form action="${ctx}/rest/appoint/update" method="post" id="appointInfoForm">
        <ul class="userinfo row">
            <input type="hidden" name="id" id="id" value="${appointment.id}">
            <li><span>预约编号：</span><input type="text" name="appointSn" id="appointSn" value="${appointment.appointSn}"/>
                <span>预约时间：</span><input type="text" name="appointmentTime" id="appointmentTime"
                                         value="${appointment.appointmentTime}" maxlength="50"/><span
                        class="_star">*</span>
            </li>
            <li><span>用户：</span><input type="text" name="call" id="call" value="${appointment.call}"/>
                <span>手机号码：</span><input type="text" name="phone" id="phone" value="${appointment.phone}"
                                         maxlength="50"/><span class="_star">*</span>
            </li>
            <li><span>预约类型：</span>
                <select name="houseType" id="houseType" class="dropdown">
                    <option value="0"
                            <c:if test="${appointment.houseType==0}">selected="selected"</c:if>>住宅
                    </option>
                    <option value="1"
                            <c:if test="${appointment.houseType==1}">selected="selected"</c:if>>公寓
                    </option>
                    <option value="2"
                            <c:if test="${appointment.houseType==2}">selected="selected"</c:if>>写字楼
                    </option>
                    <option value="3"
                            <c:if test="${appointment.houseType==3}">selected="selected"</c:if>>商铺
                    </option>
                </select>
            </li>
            <li> <span>分类：</span>
                <select name="sellRent" id="sellRent" class="dropdown">
                    <!-- <option value="" >请选择</option> -->
                    <option value="0"
                            <c:if test="${appointment.sellRent==0}">selected="selected"</c:if>>出售
                    </option>
                    <option value="1"
                            <c:if test="${appointment.sellRent==1}">selected="selected"</c:if>>出租
                    </option>
                </select>
                <span class="_star">*</span>
            </li>
            <li><span>区域：</span><input type="text" name="area" id="area" value="${appointment.area}"/>
                <span>小区：</span><input type="text" name="communityName" id="communityName"
                                       value="${appointment.communityName}" maxlength="50"/><span class="_star">*</span>
            </li>
            <li><span>地址：</span><input type="text" name="address" id="address" value="${appointment.address}"/>
            </li>
            <li><span>户型：</span><input type="text" name="layout" id="layout" value="${appointment.layout}"/>
                <span>面积：</span><input type="text" name="measure" id="measure" value="${appointment.measure}"
                                       maxlength="50"/><span class="_star">*</span>
            </li>
            <li><span>装修：</span><input type="text" name="decoration" id="decoration" value="${appointment.decoration}"/>
            </li>
            <li><span>状态：</span><select name="status" id="status" class="dropdown">
                <!-- <option value="" >请选择</option> -->
                <option value="0"
                        <c:if test="${appointment.status==0}">selected="selected"</c:if>>预约生成
                </option>
                <option value="1"
                        <c:if test="${appointment.status==1}">selected="selected"</c:if>>经纪人重新分配
                </option>
                <option value="2"
                        <c:if test="${appointment.status==2}">selected="selected"</c:if>>已联系
                </option>
            </select>
            </li>
            <li><span>备注：</span>
                <textarea  name="remark" id="remark"  style="width:260px;height:150px;resize:none; border: 1px solid #dbe2e6; border-radius: 4px; outline-color: #0099e0;">






                </textarea></li>
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
        var data = $("#appointInfoForm").serialize();
        debugger;
        $.ajax({
            type: "post",
            url: "${ctx}/rest/appoint/update",
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