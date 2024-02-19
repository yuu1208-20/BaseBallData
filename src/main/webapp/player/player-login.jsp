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
<form action="<%=request.getContextPath() %>/player/new-player-login.jsp" method="post">
	<button type="submit">新規登録</button>
</form>
<br>
<form action="<%=request.getContextPath() %>/login" method="post">
	<label for="userPlayername">ユーザー名:</label>
	<input type="text" id="userPlayername" name="userPlayername" required>
	<label for="playerPassword">パスワード:</label>
	<input type="password" id="playerPassword" name="playerPassword" required>
	<button type="submit">ログイン</button>
</form>
</body>
</html>