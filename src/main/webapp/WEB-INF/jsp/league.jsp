<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h4 class="modal-title" id="myModalLabel">Add league</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div>
                    <div >
                        <form:form name="create" method="post" action="/league" modelAttribute="league">
                            <form:hidden path="id" value="${league.id}"/>
                            <div class="form-group">
                                <span>
                                <label style="margin-left: 10px" for="league-name" class="control-label">League Name: </label>
                                <form:input cssStyle="height: 30px" path="name" id="league-name" type="text" name="name"
                                            value="${league.name}"/>
                                </span>
                                <span><button class="btn btn-danger" type="submit" value="Submit">Submit</button></span>
                            </div>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
