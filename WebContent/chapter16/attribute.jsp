<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<%-- ページ内で使用するモジュールをインポート --%>
<%@ page import="bean.Product, java.util.List" %>

<%
// リクエスト属性から「list」という名前のデータを取得
// 　戻り値はObject型 = 全てのクラスのスーパークラス
//				＝どんなクラスでも保持できるようにするため
Object obj = request.getAttribute("list");

// ObjectをList<Product>として扱うために、キャストを行う
List<Product> list=(List<Product>)obj;
%>

<% for (Product p : list){ %>
	<%= p.getId() %>:<%= p.getName() %>:<%= p.getPrice() %><br>
<% } %>


<%@ include file="../footer.html" %>