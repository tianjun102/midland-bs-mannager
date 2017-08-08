<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/assets/css/common.css">
<link rel="stylesheet" href="${ctx }/assets/css/layer.css">
<link rel="stylesheet" href="${ctx }/assets/css/easydropdown.css" />
</head>
<body>
<section class="content" style="border:none;">
	<form action="" method="post" id="addFrom">
	<ul class = "userinfo row">
			<input style = "width:264px;" type="hidden" name="id" id="id" value="${user.id}" />
			<li><span>用户名：</span><input style = "width:264px;" type="text" name="username" disabled="true" id="username" value="${user.username}" onblur="checkUserName();" maxlength="50"/><span class="_star">*</span></li>
			<li><span>用户名称：</span><input style = "width:264px;" type="text" name="userCnName" id="userCnName" value="${user.userCnName}" maxlength="50"/><span class="_star">*</span></li>
			<li style = "display:flex;align-items:center">
				<span>用户类型：</span>
				<select name="source" id="source" class="dropdown">
                    <option value="" >请选择</option>
					<option value="0"
						<c:if test="${user.source==0}">selected="selected"</c:if>>网站</option>
					<option value="1"
						<c:if test="${user.source==1}">selected="selected"</c:if>>微商</option>
				</select>
			</li>
			<li><span>手机号码：</span><input style = "width:264px;" type="text" name="phone" disabled="true" id="phone" value="${user.phone}" onblur="checkPhone();"/><span class="_star">*</span></li>
			<li><span>邮箱：</span><input style = "width:264px;" type="text" name="email" id="email" value="${user.email}" onblur="checkEmail();"/></li>

			<li style = "padding-top:30px;">
				<span></span>
				<a target="contentF" class = "public_btn bg2" id="save" onclick="saveData()">保存</a>  
				<a style="margin-left: 20px" class = "public_btn bg3" id="cancel" onclick="closeWin();">取消</a>
			</li>
		</ul>
		</form>
		
</section>	
<script type="text/javascript">
	function saveData() {
	
		if (checkUserName()&&
				checkPhone()&&
				checkEmail()) {
			var id = $("#id").val();
			var username = $("#username").val();
			var userCnName = $("input[name='userCnName']").val();
			var userType = $("#userType option:selected").val();
			var source = $("#source option:selected").val();
			var phone = $("input[name='phone']").val();
			var email = $("input[name='email']").val();
			var userRoles =""; 
			$('input[name="userRoles"]:checked').each(function(){ 
				userRoles+=$(this).val()+","; 
			}); 
			
			$.ajax({ 
					type: "post", 
					url: "${ctx}/rest/user/edit",
					async:false, // 此处必须同步
					dataType: "json",
					data:{"isFlag":1,"id":id,"username":username,"userCnName":userCnName,"userType":userType,source:source,
						"phone":phone,"email":email,"userRoles":userRoles},
					success: function(data){
						if(data.state==0){
							layer.msg("修改成功！！！",{icon:1});
							$('#save').removeAttr("onclick");
							setTimeout(function(){parent.location.reload();},1000);
							
						}else{
							layer.msg("修改失败！",{icon:2});
						}
					},
					error: function(){
						layer.msg("修改失败！",{icon:2});
					}
						
				});
			
		}
	}
	
	
	function checkUserName(){
		var regUserName = /^[a-zA-Z0-9_]{6,20}$/;
		var userName = $("#username").val();
		if(userName==null || userName.trim() =="" ){
			//$("#userNameCheck").text("用户名不能为空！");
			layer.tips("用户名不能为空！", "input[name='username']",{tips:1});
			return false;
		}
		if (!regUserName.test(userName.trim())) {
			layer.tips("仅支持英文、数字和下划线,长度为6-20个字符！", "input[name='username']",{tips:1});
			return false;
		}
		var a=true;
		<%--$.ajax({ --%>
			<%--type: "post", --%>
			<%--url: "${ctx }/rest/user/checkUnique",--%>
			<%--async:false, // 此处必须同步--%>
			<%--dataType: "json",--%>
			<%--data:{"userName":userName},--%>
			<%--success: function(xmlobj){ --%>
				<%--if (xmlobj.flag==1){--%>
					<%--layer.tips("该用户已存在！", "input[name='username']",{tips:1});--%>
					<%--a=false;--%>
				<%--}else{--%>
					<%----%>
					<%--a=true;--%>
				<%--}--%>
			<%--} --%>
		<%--});--%>
		return a;
	}
	
	//检查手机号格式
	function checkPhone() {
		var reg = /^1[3,4,5,7,8]\d{9}$/;
		var phone = $("input[name='phone']").val();
		if (phone.trim() == '') {
			layer.tips("手机号不能为空！", "input[name='phone']",{tips:3});
			return false;
		}
		if (!reg.test(phone)) {
			layer.tips("手机号格式有误,请核对!", "input[name='phone']",{tips:3});
			$("input[name='phone']").focus();
			return false;
		}
		var a=true;
		<%--$.ajax({ --%>
			<%--type: "post", --%>
			<%--url: "${ctx }/rest/user/checkPhoneUnique",--%>
			<%--async:false, // 此处必须同步--%>
			<%--dataType: "json",--%>
			<%--data:{"phone":phone},--%>
			<%--success: function(xmlobj){ --%>
				<%--if (xmlobj.flag==1){--%>
					<%--layer.tips("当前手机号码已被使用，请更换手机号码！", "input[name='phone']",{tips:1});--%>
					<%--a=false;--%>
				<%--}else{--%>
					<%--a=true;--%>
				<%--}--%>
			<%--} --%>
		<%--});--%>
		return a;
	}
	
	//检查邮箱格式
	function checkEmail() {
		var reg =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var email = $("input[name='email']").val();
		if (email.trim() == '') {
			//layer.tips("邮箱不能为空！", "input[name='email']",{tips:3});
			return true;
		}
		if (!reg.test(email)) {
			layer.tips("邮箱格式有误,请核对!", "input[name='email']",{tips:3});
			$("input[name='email']").focus();
			return false;
		}
		return true;
	}
	
	//取消
	function closeWin(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index);
	}
</script>

<script type="text/javascript" src="${ctx}/assets/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/plugins/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
<script src="${ctx}/assets/scripts/jquery.easydropdown.js" type="text/javascript"></script>
</body>
</html>