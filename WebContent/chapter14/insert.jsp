<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html" %>

<p>検索キーワードを入力してください。</p>

<form action="insert" method="post">
	商品名<input type="text" name="name">
	価格<input type="number" name="price">
	<input type="submit" value="追加">
</form>

<%@ include file="../footer.html" %>