<html>
<head>
	<title>student</title>
	<meta http-equiv=Content-Type content="text/html;charset=utf-8">
</head>
<body>
	学生信息：<br>
	学号：${stu.id}<br>
	姓名：${stu.name}<br>
	年龄：${stu.age}<br>
	家庭住址：${stu.address}<br>
	学生列表：<br>
	<table border="1">
		<tr>
			<th>序号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>家庭住址</th>
		</tr>
		<#list stuList as student>
		<#if student_index % 2 == 0>
		<tr bgcolor="red">
		<#else>
		<tr bgcolor="blue">
		</#if>
			<td>${student_index}</td>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.age}</td>
			<td>${student.address}</td>
		</tr>
		</#list>
	</table>
	<br>
	当前日期：${date?date}<br>
	当前时间：${date?time}<br>
	日期和时间：${date?datetime}<br>
	自定义日期时间格式：${date?string("yyyy/MM/dd HH:mm:ss")}<br>
	null值的处理：${val!"val的值为null"}<br>
	判断val的值是否为null：
	<#if val??>
		val的值不为null，是：${val}
	<#else>
		val的值是null。。。。。。。
	</#if>
	<br>
	引用hello.ftl模板：
	<#include "hello.ftl">

</body>
</html>