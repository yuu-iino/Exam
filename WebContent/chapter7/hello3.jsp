<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.html" %>

<p>Hello!</p>
<p>こんにちは！</p>

<p>
<%-- <% コード; %>：スクリプトレット：HTML内にJavaのコードを埋め込む --%>
<%
int x = 10;
int y = 20;
out.println(new java.util.Date());
out.println(x + "+" + y + "=" + (x+y) );
%>
</p>

<%@include file="../footer.html" %>