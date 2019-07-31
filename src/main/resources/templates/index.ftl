<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<#assign basePath = springMacroRequestContext.getContextPath()/>
		<title>主页</title>
		<link rel="stylesheet" href="${basePath}/layui/css/layui.css" />
		<script type="text/javascript" src="${basePath}/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
			body {
				margin: 50px;
			}
		</style>
	</head>

	<body>
		
		<button id="selectBtn" class="layui-btn layui-btn-sm layui-btn-radius layui-bg-cyan">
			<i class="layui-icon">&#xe602;</i>select
		</button>
		<button id="insertBtn" class="layui-btn layui-btn-normal layui-btn-sm layui-btn-radius">
			<i class="layui-icon">&#xe654;</i>insert
		</button>
		<button id="updateBtn" class="layui-btn layui-btn-warm layui-btn-sm layui-btn-radius">
			<i class="layui-icon">&#xe642;</i>update
		</button>
		<button id="deleteBtn" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius">
			<i class="layui-icon">&#xe640;</i>delete
		</button>

		<hr />
		<button id="vipBtn" class="layui-btn layui-btn-lg">
			vip
		</button>
		<button id="ipBtn" class="layui-btn layui-btn-lg">
			ip
		</button>
		<button id="pBtn" class="layui-btn layui-btn-lg">
			p
		</button>
		
		<hr/>
		<a class="layui-btn layui-btn-sm layui-btn-primary" href="${basePath}/user/logout">注销</a>
	</body>
	<script type="text/javascript">
		$("#selectBtn").click(function() {
			$.post("${basePath}/user/select", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert(result.errorInfo);
					return false;
				}
			});
		});
		$("#insertBtn").click(function() {
			$.post("${basePath}/user/insert", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert(result.errorInfo);
					return false;
				}
			});
		});
		$("#updateBtn").click(function() {
			$.post("${basePath}/user/update", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert(result.errorInfo);
					return false;
				}
			});
		});
		$("#deleteBtn").click(function() {
			$.post("${basePath}/user/delete", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert(result.errorInfo);
					return false;
				}
			});
		});
		$("#vipBtn").click(function() {
			$.post("${basePath}/user/vip", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert('无权访问');
					return false;
				}
			});
		});
		$("#ipBtn").click(function() {
			$.post("${basePath}/user/ip", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert('无权访问');
					return false;
				}
			});
		});
		$("#pBtn").click(function() {
			$.post("${basePath}/user/p", {}, function(result) {
				if(result.success) {
					alert(result.msg);
					return false;
				} else {
					alert('无权访问');
					return false;
				}
			});
		});
	</script>

</html>