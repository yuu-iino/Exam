<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<p>カードに追加する商品を追加していください。</p>
<form action="cart-add" method="post">
商品名<input type="text" name="name">
価格<input type="text" name="price">
<input type="submit" value="追加">
</form>

<%@ include file="../footer.html" %>