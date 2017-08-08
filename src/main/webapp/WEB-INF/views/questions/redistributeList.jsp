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
            <th style="width: 5%"></th>
            <th style="width: 5%">序号</th>
            <th style="width: 5%">用户名</th>
            <th style="width: 10%">手机号码</th>
            <th style="width: 5%">注册时间</th>
            <th style="width: 10%">注册来源</th>
            <th style="width: 4%">实名状态</th>
            <th style="width: 5%">审核人</th>
            <th style="width: 10%">审核时间</th>
            <th style="width: 10%">用户类型</th>
            <th style="width: 15%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${!empty requestScope.users }">
                <c:forEach items="${requestScope.users }" var="cust" varStatus="xh">
                    <tr>
                        <td><input name="radio" type="radio" value="${cust.id }"/></td>

                        <td>${xh.count }</td>
                        <td>${cust.username }</td>
                        <td>${cust.phone }</td>
                        <td>${cust.createTime }</td>
                        <td> <c:if test="${appoint.source ==0 }">网站</c:if>
                            <c:if test="${appoint.source ==1 }">微站</c:if></td>
                        <td>${cust.auditStatus }</td>
                        <td>${cust.auditName }</td>
                        <td>${cust.auditTime }</td>
                        <td>
                            <c:if test="${cust.userType==0}">智者汇</c:if>
                            <c:if test="${cust.userType==1}">渠道服务商</c:if>
                        </td>
                        <td>

                            <a target="contentF" onclick="alterUser(${cust.id })">编辑</a>

                            <a target="contentF" onclick="takeblacklist(${cust.id })">加入黑名单</a>
                            <a target="contentF" onclick="viewRealRegistration(${cust.id })">
                                <c:choose>
                                    <c:when test="${cust.auditStatus==0}">审核实名信息
                                    </c:when>
                                    <c:otherwise>查看实名信息
                                    </c:otherwise>
                                </c:choose>
                            </a>
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
<ul class = "userinfo row">
    <li style="padding-top:30px;">
        <span></span>
        <a target="contentF" class="public_btn bg2" id="save" onclick="saveData()">确定</a>
        <a style="margin-left: 20px" class="public_btn bg3" id="cancel" onclick="closeWin();">取消</a>
    </li>
</ul>

<script type="text/javascript">
    function saveData(){
        var entrustId = $("#entrustId").val();
        var intHot = $("input[name='radio']:checked");
        var agentId = intHot.parent().next().text();
        var agentName = intHot.parent().next().next().text();
        $.ajax({
            type: "post",
            url: "${ctx}/rest/entrust/reset_agent",
            async: false, // 此处必须同步
            dataType: "json",
            data: {
                "id": entrustId, "userId": agentId, "userCnName": agentName
            },
            success: function (data) {
                if (data.state == 0) {
                    layer.msg("删除成功！！！", {icon: 1});
                    $('#save').removeAttr("onclick");
                    setTimeout(function () {
                        parent.location.reload();
                    }, 1000);

                } else {
                    layer.msg("删除失败！", {icon: 2});
                }
            },
            error: function () {
                layer.msg("删除失败！", {icon: 2});
            }

        });
    }




    function takeblacklist(userId) {
        layer.open({
            type: 1,
            title: ['加入黑名单'],
            shade: 0.3,
            area: ['500px', '500px'],
            content: '<form action="${ctx}/rest/user/update" method="post" id="blackForm">'
            + '<ul class = "userinfo row"><input type="hidden" name="id" id="id" value="' + userId + '">'
            + '<li><span>拉黑原因：</span><textarea style="width:80%;height:100px" name="blackRemark" id="blackRemark"></textarea></li>'
            + '<li><a target="contentF" class = "public_btn bg2" id="save" onclick="consume(' + userId + ')">加入黑名单</a>'
            + '</ul></form>'
        });
    }
    function alterUser(userId) {
        layer.open({
            type: 2,
            title: ['编辑用户'],
            shade: 0.3,
            area: ['500px', '500px'],
            content: ['${ctx}/rest/user/toUpdatePage?userId=' + userId, 'no']
        });
    }


    function consume(userId) {
        $.ajax({
            type: "post",
            url: "${ctx}/rest/user/update?id=" + userId + '&isBlack=1' + '&blackRemark=' + $('#blackRemark').val(),
            cache: false,
            async: false, // 此处必须同步
            dataType: "json",
            success: function (obj) {
                if (obj.state == 0) {
                    layer.msg("成功！", {icon: 5});
                    parent.window.location.reload();
                    parent.layer.closeAll();
                }
                if (obj.state == -1) {
                    layer.msg("失败！！", {icon: 7});
                }

            }
        });
    }


    function isDelete(userId) {
        layer.open({
            type: 1,
            skin: 'layer-style',
            area: ['350px', '200px'],
            shadeClose: false, //点击遮罩关闭
            title: ['删除用户'],
            resize: false,
            scrollbar: false,
            content: '<section class = "content" style = "border:none; height:100%;">' +
            '<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您确定要删除当前用户吗?</p>' +
            '</section>',
            btn: ['确定', '取消'],
            yes: function (index) {
                $.ajax({
                    type: "post",
                    url: "${ctx}/rest/user/deleteUser?userId=" + userId,
                    cache: false,
                    async: false, // 此处必须同步
                    dataType: "json",
                    success: function (xmlobj) {
                        if (xmlobj.flag == 1) {
                            layer.msg("删除成功！", {icon: 1});
                            setTimeout(function () {
                                $("#searchForm").submit();
                            }, 1000);
                        }
                        if (xmlobj.flag == 0) {
                            layer.msg("删除失败！！", {icon: 7});
                        }
                        layer.close(index);
                    }
                });
            }
            , success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.css('text-align', 'center');
            }
        });

    }

    //重置
    function isReset(userId) {

        layer.open({
            type: 1,
            skin: 'layer-style',
            area: ['350px', '200px'],
            shadeClose: false, //点击遮罩关闭
            title: ['重置密码'],
            resize: false,
            scrollbar: false,
            content: '<section class = "content" style = "border:none; height:100%;">' +
            '<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您是否确定重置该用户的密码?</p>' +
            '</section>',
            btn: ['确定', '取消'],
            yes: function (index) {
                $.ajax({
                    type: "post",
                    url: "${ctx}/rest/user/resetPwd?userId=" + userId,
                    cache: false,
                    async: false, // 此处必须同步
                    dataType: "json",
                    success: function (xmlobj) {
                        if (xmlobj.flag == 1) {
                            layer.msg("已重置！", {icon: 1});
                        }
                        if (xmlobj.flag == 0) {
                            layer.msg("重置失败！！", {icon: 7});
                        }
                        layer.close(index);
                    }
                });
            }
            , success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.css('text-align', 'center');
            }
        });
    }
    //修改
    function preUpdate(userId) {
        layer.open({
            type: 2,
            title: ['用户信息'],
            shade: 0.3,
            area: ['500px', '520px'],
            content: ['${ctx}/rest/user/findUser?userId=' + userId, 'no']
        });
    }
    //角色列表
    function userRole(userId, userName) {
        layer.open({
            type: 2,
            title: ['用户角色信息:' + userName],
            shade: 0.3,
            area: ['600px', '450px'],
            content: ['${ctx}/rest/user/userRole?userId=' + userId, 'yes']
        });
    }
    //查看
    function viewUser(userId) {
        layer.open({
            type: 2,
            title: ['用户信息'],
            shade: 0.3,
            area: ['600px', '550px'],
            content: ['${ctx}/rest/user/findUser?userId=' + userId, 'no']
        });
    }
    //启用关闭
    function isOffOn(userId, state) {
        if (state == "0") {

            layer.open({
                type: 1,
                skin: 'layer-style',
                area: ['350px', '200px'],
                shadeClose: false, //点击遮罩关闭
                title: ['启用'],
                resize: false,
                scrollbar: false,
                content: '<section class = "content" style = "border:none; height:100%;">' +
                '<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您是否确定开启该用户?</p>' +
                '</section>',
                btn: ['确定', '取消'],
                yes: function (index) {
                    $.ajax({
                        type: "post",
                        url: "${ctx}/rest/user/offOn?id=" + userId + "&state=1",
                        cache: false,
                        async: false, // 此处必须同步
                        dataType: "json",
                        success: function (xmlobj) {
                            if (xmlobj.flag == 1) {
                                layer.msg("已重新开启！", {icon: 1});
                            }
                            if (xmlobj.flag == 0) {
                                layer.msg("操作失败！！", {icon: 7});
                            }
                            setTimeout(function () {
                                $("#searchForm").submit();
                            }, 1000);
                            layer.close(index);
                        }
                    });
                }
                , success: function (layero) {
                    var btn = layero.find('.layui-layer-btn');
                    btn.css('text-align', 'center');
                }
            });
        } else {
            layer.open({
                type: 1,
                skin: 'layer-style',
                area: ['350px', '200px'],
                shadeClose: false, //点击遮罩关闭
                title: ['关闭'],
                resize: false,
                scrollbar: false,
                content: '<section class = "content" style = "border:none; height:100%;">' +
                '<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您是否确定关闭该用户?</p>' +
                '</section>',
                btn: ['确定', '取消'],
                yes: function (index) {
                    $.ajax({
                        type: "post",
                        url: "${ctx}/rest/user/offOn?id=" + userId + "&state=0",
                        cache: false,
                        async: false, // 此处必须同步
                        dataType: "json",
                        success: function (xmlobj) {
                            if (xmlobj.flag == 1) {
                                layer.msg("已关闭！", {icon: 1});
                            }
                            if (xmlobj.flag == 0) {
                                layer.msg("操作失败！！", {icon: 7});
                            }
                            setTimeout(function () {
                                $("#searchForm").submit();
                            }, 1000);
                            layer.close(index);
                        }
                    });
                }
                , success: function (layero) {
                    var btn = layero.find('.layui-layer-btn');
                    btn.css('text-align', 'center');
                }
            });
        }
    }
</script>
</body>
</html>