<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/tablib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>省市区</title>
</head>
<body>

            <li class="col-sm-6 col-md-6 col-lg-6"><span>省：</span> <!-- 省 -->
                <p id="province" style="display: inline-block;height: 38px;">
                    <label ></label> <input type="hidden" name="provinceId">
                    <input type="hidden" name="regionSn"> <input type="hidden"
                                                                 name="provinceName">
                    <!-- 第一次进页面加载省 -->
                    <select id="provinces" onchange="initProvince()"
                            style="height: 100%;width: 65px; display: inline-table;border-radius: 4px;border: 1px solid #dbe2e6;">
                        <option>请选择</option>
                        <c:forEach items="${provinceList}" var="province">
                            <option
                                    value="${province.parentId}">${province.parentName}
                            </option>
                        </c:forEach>
                    </select>
                </p>
                <!-- 市 -->
                &nbsp;&nbsp;
                <p id="city" style="display: inline-block;height: 38px;">
                    <span>市：</span>
                    <label ></label> <input type="hidden" name="cityId">
                    <input type="hidden" name="cityName">
                    <select id="citys" onchange="initCity()" style="height: 100%;width: 65px; display: inline-table;border-radius: 4px;border: 1px solid #dbe2e6;">
                        <option value="">请选择</option>
                    </select>
                </p>

                &nbsp;&nbsp;
                <p id="district" style="display: inline-block;height: 38px;">
                    <span>地区：</span>
                    <label ></label> <input type="hidden" value="" name="distId"> <input type="hidden" value="" name="distName">
                    <select id="districts" onchange="initDistrict()" style="height: 100%;width: 65px; display: inline-table;border-radius: 4px;border: 1px solid #dbe2e6;">
                        <option value="">请选择</option>
                    </select>
                </p>
            </li>

            <li class="col-sm-6 col-md-6 col-lg-6"class="col-sm-6 col-md-6 col-lg-6">
                <!-- 片区 -->
                <span>片区：</span>
                <p id="sheet" style="display: inline-block;height: 38px;">
                    <label ></label> <input type="hidden" value="" name="sheetId"> <input type="hidden" value="" name="sheetName">
                    <select id="sheets" onchange="initSheet()" style="height: 100%;width: 248px; display: inline-table;border-radius: 4px;border: 1px solid #dbe2e6;">
                        <option value="">请选择</option>
                    </select>
                </p>
            </li>

<script type="text/javascript">

    //省级赋值
    function initProvince() {
        var addrId = $("#provinces option:selected").val();
        var addName = $("#provinces option:selected").text();
        $("#districts").html("<option  >请选择</option>");
        /*if ("请选择" == addName) {
            //下级改变成请选择
            $("#citys option:selected").text(addName);
            $("#districts option:selected").text(addName);
            $("#citys").html("<option  >请选择</option>");

            $("input[name=provinceId]").val("");
            $("input[name=provinceName]").val("");
            $("input[name='cityId']").val("");
            $("input[name='cityName']").val("");
            $("input[name='distId']").val("");
            $("input[name='distName']").val("");
            return;
        }*/
        $("input[name=provinceId]").val(addrId);
        $("input[name=provinceName]").val(addName);


        $.ajax({
            type : "post",
            url : "${ctx}/rest/setting/seleAddress?flag=city&id=" + addrId,
            async : false, // 此处必须同步
            dataType : "json",
            data : "",
            success : function(data) {
                $("#citys").html("<option  >请选择</option>");

                data.result.forEach(function(list) {
                    $("#citys").append(
                        "<option value="+list.id+" >" + list.name + "</option>");
                })
            }
        });
    }


    //市级赋值
    function initCity() {
        var addrId = $("#citys option:selected").val();
        var addName = $("#citys option:selected").text();
        if ("请选择" == addName) {
            //下级改变成请选择
            $("#districts option:selected").text(addName);
            $("#districts").html("<option  >请选择</option>");
            //其值及其下级值变成空
            $("input[name='cityId']").val("");
            $("input[name='cityName']").val("");
            $("input[name='distId']").val("");
            $("input[name='distName']").val("");
            return;
        }
        $("input[name='cityId']").val(addrId);
        $("input[name='cityName']").val(addName);
        $.ajax({
            type : "post",
            url : "${ctx}/rest/setting/seleAddress?flag=area&id=" + addrId,
            async : false, // 此处必须同步
            dataType : "json",
            data : "",
            success : function(data) {
                $("#districts").html("<option value='' >请选择</option>");
                data.result.forEach(function(list) {
                    $("#districts").append(
                        "<option value="+list.id+" >"
                        + list.name + "</option>");
                })
            }
        });
    }


    //区级赋值
    function initDistrict() {
        var cityId =$("input[name='cityId']").val();
        var addrId = $("#districts option:selected").val();
        var addName = $("#districts option:selected").text();
        if ("请选择" == addName) {
            //下级改变成请选择
            $("#districts option:selected").text(addName);
            //其值及其下级值变成空
            $("input[name='distId']").val("");
            $("input[name='distName']").val("");
            return;
        }
        $("input[name='distId']").val(addrId);
        $("input[name='distName']").val(addName);

        $.ajax({
            type : "post",
            url : "${ctx}/rest/setting/seleAddress?flag=sheet&id=" + cityId+"&parentId=" + addrId,
            async : false, // 此处必须同步
            dataType : "json",
            data : "",
            success : function(data) {
                $("#sheets").html("<option value='' >请选择</option>");
                data.result.forEach(function(list) {
                    $("#sheets").append(
                        "<option value="+list.id+" >"
                        + list.name + "</option>");
                })
            }
        });

    }


    //区级赋值
    function initSheet() {
        var cityId =$("input[name='cityId']").val();
        var addrId = $("#sheets option:selected").val();
        var addName = $("#sheets option:selected").text();
        if ("请选择" == addName) {
            //下级改变成请选择
            $("#sheets option:selected").text(addName);
            //其值及其下级值变成空
            $("input[name='sheetId']").val("");
            $("input[name='sheetName']").val("");
            return;
        }
        $("input[name='sheetId']").val(addrId);
        $("input[name='sheetName']").val(addName);

    }



</script>

</body>
</html>