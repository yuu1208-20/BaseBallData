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
<form action="<%=request.getContextPath() %>/team/team-login.jsp">
	<button>チーム関係者ログイン</button>
</form>
<br>
<form action="<%=request.getContextPath() %>/player/player-login.jsp">
	<button>選手ログイン</button>
</form>
</body>
</html>