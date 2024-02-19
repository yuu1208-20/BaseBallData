<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フリーエージェントマーケットプレイス</title>
</head>
<body>
	<h1>BaseBallFreeAjent</h1>
	<h2><チーム関係者画面></h2>
	<form action="<%=request.getContextPath() %>/team-login" method="post">
		<label for="teamUsername">ユーザー名:</label>
		<input type="text" id="teamUsername" name="teamUsername" required>
		<label for="teamPassword">パスワード:</label>
		<input type="password" id="teamPassword" name="teamPassword" required>
		<button type="submit">登録</button>
	</form>
</body>
</html>