<%@ page import="com.game.game.GameButtons" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Игра крестики-нолики</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div>
    <% GameButtons game = GameButtons.getInstance(); %>
    <c:if test="${empty end}">
    <table id="tb" align="center">
        <form id="go" action="${pageContext.request.contextPath}/game" method="get"></form>
        <tr>
            <%if (game.getButton(0,0).equals("X")){%>
            <td id="00">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
            if (game.getButton(0,0).equals("O")){%>
            <td id="00">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="00">
                <input class ="button" type="submit" name="step" value="00" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
            <%if (game.getButton(0,1).equals("X")){%>
            <td id="01">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(0,1).equals("O")){%>
            <td id="01">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="01">
                <input class ="button" type="submit" name="step" value="01" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
            <%if (game.getButton(0,2).equals("X")){%>
            <td id="02">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(0,2).equals("O")){%>
            <td id="02">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="02">
                <input class ="button" type="submit" name="step" value="02" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
        </tr>
        <tr>
            <%if (game.getButton(1,0).equals("X")){%>
            <td id="10">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(1,0).equals("O")){%>
            <td id="10">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="10">
                <input class ="button" type="submit" name="step" value="10" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
            <%if (game.getButton(1,1).equals("X")){%>
            <td id="11">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(1,1).equals("O")){%>
            <td id="11">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="11">
                <input class ="button" type="submit" name="step" value="11" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
            <%if (game.getButton(1,2).equals("X")){%>
            <td id="12">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(1,2).equals("O")){%>
            <td id="12">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="12">
                <input class ="button" type="submit" name="step" value="12" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
        </tr>
        <tr>
            <%if (game.getButton(2,0).equals("X")){%>
            <td id="20">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(2,0).equals("O")){%>
            <td id="20">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="20">
                <input class ="button" type="submit" name="step" value="20" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
            <%if (game.getButton(2,1).equals("X")){%>
            <td id="21">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(2,1).equals("O")){%>
            <td id="21">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="21">
                <input class ="button" type="submit" name="step" value="21" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
            <%if (game.getButton(2,2).equals("X")){%>
            <td id="22">
                <img src ="${pageContext.request.contextPath}/resources/images/cross.jpg"/>
            </td>
            <%}
            else{
                if (game.getButton(2,2).equals("O")){%>
            <td id="22">
                <img src ="${pageContext.request.contextPath}/resources/images/noll.jpg"/>
            </td>
            <%}else{%>
            <td id="22">
                <input class ="button" type="submit" name="step" value="22" form="go" style="text-indent: -9999px">
            </td>
            <%}}%>
        </tr>
    </table>
    </c:if>
    <c:if test="${not empty end}">
        <h1>${end}</h1>
        <form method="post" action="${pageContext.request.contextPath}/game">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Restart</button>
        </form>
        <form method="get" action="${pageContext.request.contextPath}/welcome">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Back</button>
        </form>
    </c:if>
</div>
</body>
</html>