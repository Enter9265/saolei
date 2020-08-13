<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/20
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    table {

        padding: 0px;
        border: 0px;

    }

    td {
        margin: 0px;
        padding: 0px;
            /*height: 30px;*/
            /*width: 30px;*/
    }
</style>
<body>


<table align="center">
    <c:forEach begin="0" end="${index.x}" var="i">
        <tr>
            <c:forEach begin="0" end="${index.y}" var="y">
                <td>
                     <input value="${index.s[i][y]}" name="image" type="image" src="img/01.png" onclick="show(this)">
                </td>
            </c:forEach>
        </tr>
    </c:forEach>

</table>

</body>

<script type="text/javascript">

    function show(obj) {

        //如果点到了空白
        if (obj.value == 0){

            obj.src="img/0000.png";




        }else if (obj.value == 1){
            obj.src="img/001.png";
        }else if (obj.value == 2){
            obj.src="img/002.png";
        }else if (obj.value == 3){
            obj.src="img/003.png";
        }else if (obj.value == 4){
            obj.src="img/004.png";
        }else if (obj.value == 5){
            obj.src="img/005.png";
        }else if (obj.value == 6){
            obj.src="img/006.png";
        }else if (obj.value >=100){
            obj.src="img/jj.png";
        }
    }

    var elementsByTagName = document.getElementsByTagName("td");

    for (var i = 0; i <elementsByTagName.length; i++){
        if (elementsByTagName[i].innerHTML == 0){
            elementsByTagName[i].innerHTML=" <img src=\"img/0000.png\">"
        }
    }


</script>
</html>
