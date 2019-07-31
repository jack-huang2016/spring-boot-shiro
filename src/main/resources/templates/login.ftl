<!DOCTYPE html>
<html>
	
<head>
		<meta charset="UTF-8">
		<#assign basePath = springMacroRequestContext.getContextPath()/>
		<title>登录页面</title>
		<link type="text/css" rel="stylesheet" href="${basePath}/layui/css/layui.css" />
		<script type="text/javascript" src="${basePath}/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
		</style>
	
</head>

	<body>
		<br />
		<div class="layui-form-item">
			<label class="layui-form-label">用户名:</label>
			<div class="layui-input-block">
				<!-- 1、参数必须被命名为 userName，不能为 username，保持和实体中的属性一致 -->
				<input type="text" id="userName" name="userName" placeholder="userName" class="layui-input" autocomplete="off"><br/>
			</div>

			<label class="layui-form-label">密码:</label>
			<div class="layui-input-block">
				<!-- 2、同理密码参数必须被命名为 password -->
				<input type="password" id="password" name="password" placeholder="password" class="layui-input"><br/>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="submit" id="loginBtn" value="登录" class="layui-btn"></input>
			</div>
		</div>
	</body>
	
	<script type="text/javascript">
		$("#loginBtn").click(function() {
			$.post("${basePath}/user/login", {
				userName: $("#userName").val(),
				password: $("#password").val(),
			}, function(result) {
				if(result.success) {
					location.href = 'index';
				} else {
					alert(result.errorInfo);
				}
			});
		});
	</script>

</html>