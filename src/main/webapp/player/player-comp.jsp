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
<h3>登録完了しました。</h3>
<form action="<%=request.getContextPath() %>/player/player-login.jsp" method="post">
	<button type="submit">ログイン画面へ</button>
</form>
<br>
<form action="<%=request.getContextPath() %>/home.jsp" method="psot">
	<button type="submit">ホームに戻る</button>
</form>
	
</body>
</html>