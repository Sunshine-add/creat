<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link type="text/css" href="css/style.css" rel="stylesheet" />
</head>
<body>
	<!--  action="select" 去web.xml里边找映射地址位/select的类 -->
	<div class="form-wrap">
		<form action="select" method="POST">
			<div class="input-wrap">
				<input type="text" id="title"> <label for="username">输入框</label>
			</div>

			<div class="input-wrap">
				<button class="layui-btn layui-btn-normal" data-method="offset"
					data-type="auto">查找</button>
			</div>
		</form>
	</div>

	<script src="js/jquery.js"></script>
	<script src="js/index.js"></script>
	<script>
		$(document).ready(function() {
			$('.form-wrap').finput();
		})
	</script>


	<!-- 示例-970 -->
	<ins class="adsbygoogle"
		style="display: inline-block; width: 970px; height: 90px"
		data-ad-slot="3820120620" data-ad-client="ca-pub-6111334333458862"></ins>

	
	

	<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui
				.use(
						'layer',
						function() { //独立版的layer无需执行这一句
							var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

							//触发事件
							var active = {
								setTop : function() {
									var that = this;
									//多窗口模式，层叠置顶
									layer
											.open({
												type : 2 //此处以iframe举例
												,
												title : '当你选择该窗体时，即会在最顶端',
												area : [ '390px', '260px' ],
												shade : 0,
												maxmin : true,
												offset : [ //为了演示，随机坐标
														Math.random()
																* ($(window)
																		.height() - 300),
														Math.random()
																* ($(window)
																		.width() - 390) ],
												content : '${Address}',
												
												,
												yes : function() {
													$(that).click();
												},
												btn2 : function() {
													layer.closeAll();
												}

												,
												zIndex : layer.zIndex //重点1
												,
												success : function(layero) {
													layer.setTop(layero); //重点2
												}
											});
								},
								
								
								
							};

							$('#layerDemo .layui-btn').on(
									'click',
									function() {
										var othis = $(this), method = othis
												.data('method');
										active[method] ? active[method].call(
												this, othis) : '';
									});

						});
	</script>

</body>
</html>