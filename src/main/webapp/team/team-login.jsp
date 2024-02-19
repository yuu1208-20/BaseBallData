<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フリーエージェントマーケットプレイス</title>
</head>
<body>
<h1>BaseBallFreeAgent</h1>
<h2><チーム関係者画面></h2>
<form action="<%=request.getContextPath() %>/team/new-team-login.jsp" method="post">
	<button type="submit">新規登録はこちら</button>
</form>
<br>
<form action="<%=request.getContextPath() %>/team/team-dashboard.jsp" method="post">
	<label for="teamUsername">ユーザー名:</label>
	<input type="text" id="teamUsername" name="teamUsername" required>
	<label for="teamPassword">パスワード:</label>
	<input type="password" id="teamPassword" name="teamPassword" required>
	<button type="submit">ログイン</button>
</form>
</body>
</html>