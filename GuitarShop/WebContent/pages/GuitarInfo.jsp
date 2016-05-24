<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <style>
 .table-a table {
 	border: 1px solid #F00
 }
 </style>
 
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>查詢結果</title>
 </head>
 <body>
 	<p align="center">您查询的吉他信息：</p>
 	<div class="table-a">
 		<table border="1" align="center">
 			<tr>
 				<td>编号</td>
 				<td>价格</td>
 				<td>制造者</td>
 				<td>模式</td>
 				<td>类型</td>
 				<td>背木</td>
 				<td>顶木</td>
 
 			</tr>
 
 			<c:forEach items="${requestScope.list}" var="g">
 				<tr>
 					<td>${g.serialNumber}</td>
 					<td>${g.price}</td>
 					<td>${g.builder }</td>
 					<td>${g.model}</td>
 					<td>${g.type}</td>
 					<td>${g.backWood}</td>
 					<td>${g.topWood}</td>
 				</tr>
 			</c:forEach>
 		</table>
 	</div>
 </body>
 </html>