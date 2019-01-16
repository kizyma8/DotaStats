<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kizyma8
  Date: 04/12/18
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add League</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.no-icons.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<%@ include file="layout/header.jsp" %>
<div id="login-overlay" class="modal-dialog" style="margin-top: 100px">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">Formula</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div>
                    <div>
                        <c:choose>
                            <c:when test="${response != null}">
                                <span style="margin-left: 10px">Next Bet: ${response}</span>
                            </c:when>
                            <c:otherwise>
                                <form:form name="create" method="post" action="/formula" modelAttribute="formula">
                                    <%--<div class="form-group">--%>
                                <%--<span>--%>
                                <%--<label style="margin-left: 10px" for="coeff" class="control-label">Previous Coefficient: </label>--%>
                                <%--<form:input cssStyle="height: 30px" path="prevCoefficient" id="coeff" type="text"--%>
                                            <%--name="name"--%>
                                            <%--value="${formula.prevCoefficient}"/>--%>
                                <%--</span>--%>
                                    <%--</div>--%>
                                    <div class="form-group">
                                        <span>
                                <label style="margin-left: 10px;width: 200px" for="prev-bet"
                                       class="control-label">Profit</label>
                                <form:input cssStyle="height: 30px" path="profit" id="prev-bet" type="text"
                                            name="name"
                                            value="${formula.profit}"/>
                                </span>
                                    </div>
                                    <div class="form-group">
                                        <span>
                                <label style="margin-left: 10px;width: 200px" for="prev-bet"
                                       class="control-label">Coefficient: </label>
                                <form:input cssStyle="height: 30px" path="coefficient" id="prev-bet" type="text"
                                            name="name"
                                            value="${formula.coefficient}"/>
                                </span>
                                    </div>
                                    <div class="form-group">
                                        <span>
                                <label style="margin-left: 10px;width: 200px" for="prev-bet"
                                       class="control-label">Lost money: </label>
                                <form:input cssStyle="height: 30px" path="moneyLost" id="prev-bet" type="text"
                                            name="name"
                                            value="${formula.moneyLost}"/>
                                </span>
                                    </div>
                                    <div class="form-group">
                                        <span style="margin-left: 25px"><button class="btn btn-danger" type="submit"
                                                      value="Submit">Submit</button></span>
                                    </div>
                                </form:form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
