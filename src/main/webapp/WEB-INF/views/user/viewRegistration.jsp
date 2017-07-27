<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/assets/css/common.css">

</head>
<body>
<section class = "content" style = "border:none;">
<form action="${ctx}/rest/user/edit" method="post" id="userInfoForm">
	<ul class = "userinfo row">
		<input type="hidden" name="id" id="id" value="${user.id}">
		<input type="hidden" name="ph" id="ph" value="${user.phone}">
		<li><span>用户名：</span><input type="text" name="userName" id="userName" value="${user.username}" disabled="disabled"/></li>
		<li><span>身份证号码：</span><input type="text" name="identification" id="identification" value="${user.identification}" maxlength="50"/><span class="_star">*</span></li>
		<li><span>身份证图片：</span><img style="width: 90px;height: 90px;" src="${user.idcartImg}"  maxlength="50"/></li>
		<li><img style="width: 90px;height: 90px;" src="${user.idcartImg1}"  maxlength="50"/></li>
		</ul>
			
	</form>	
</section>

<script type="text/javascript">
	//保存数据
	function saveData(){
		if(checkPhone()&&checkEmail()){
			var id = $("#id").val();
			var username = $("#username").val();
			var userCnName = $("input[name='userCnName']").val();
			// var userType = $("input[name='userType']").val();
			// var userType = $("#userType option:selected").val();
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
					data:{"id":id,"username":username,"userCnName":userCnName,
						"phone":phone,"email":email,"userRoles":userRoles},
					success: function(data){
						if(data.flag==1){
							layer.msg("保存成功！！！",{icon:1});
							$('#save').removeAttr("onclick");
							setTimeout(function(){parent.location.reload();},1000);
							
						}else{
							layer.msg("保存失败！",{icon:2});
						}
					},
					error: function(){
						layer.msg("保存失败！",{icon:2});
					}
				});
		}
	}
	//检查手机号格式
	function checkPhone() {
		debugger;
		var phone0 = $("#ph").val();
		var reg = /^1[3,4,5,7,8]\d{9}$/;
		var phone = $("input[name='phone']").val();
		if (phone.trim() == '') {
			layer.tips("手机号不能为空！", "input[name='phone']",{tips:1});
			return false;
		}
		if (!reg.test(phone)) {
			layer.tips("手机号格式有误,请核对!", "input[name='phone']",{tips:3});
			return false;
		}
		if(phone0==phone){
			return true;
		}
		
		var a=true;
		$.ajax({ 
			type: "post", 
			url: "${ctx }/rest/user/checkPhoneUnique",
			async:false, // 此处必须同步
			dataType: "json",
			data:{"phone":phone},
			success: function(xmlobj){ 
				if (xmlobj.flag==1){
					layer.tips("当前手机号码已被使用，请更换手机号码！", "input[name='phone']",{tips:1});
					a=false;
				}else{
					a=true;
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
			layer.tips("邮箱格式有误,请核对!", "input[name='email']",{tips:3});
			//$("input[name='email']").focus();
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
<script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
</body>
</html>