<%--
  Created by IntelliJ IDEA.
  User: 贺武康
  Date: 2019/4/16
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<button onclick="a()">aaa</button>
<input type="text" value="aaa" id="a">
<script>
    function a(){
        layer.msg("aaa")
    var a = $("#a").val();
    alert(a)
        alert("aaaa");
    }

</script>
</body>
</html>
