<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
	<h2>生徒の情報を更新します</h2>
	<form action="/sampleDBweb2/editStudent" method="post">
	番号 <input type="text" name="no"/><br/>
	名前 <input type="text" name="name"/><br/>
	点数 <input type="text" name="score"/><br/><br/>
	<input type="submit" name="btn" value="追加"/>
	<input type="submit" name="btn" value="修正"/>
	<input type="submit" name="btn" value="削除"/>
	<input type="submit" name="btn" value="表示"/>	
	</form>
</body>
</html>