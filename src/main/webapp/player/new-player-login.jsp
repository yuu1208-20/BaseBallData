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
	<h2><選手画面></h2>
	<form action="<%=request.getContextPath() %>/player-login" method="post">
		<label for="userPlayername">ユーザー名:</label>
		<input type="text" id="userPlayername" name="userPlayername" required>
		<label for="playerPassword">パスワード:</label>
		<input type="password" id="playerPassword" name="playerPassword" required>
		<button type="submit">登録</button>
	</form>
</body>
</html>