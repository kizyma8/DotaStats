<%--
  Created by IntelliJ IDEA.
  User: kizyma8
  Date: 04/12/18
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add  Team</title>
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
            <h4 class="modal-title" id="myModalLabel">Add team</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div>
                    <div >
                        <form:form name="create" method="post" action="/team" modelAttribute="team">
                            <form:hidden path="id" value="${team.id}"/>
                            <div class="form-group">
                                <span>
                                <label style="margin-left: 10px" for="team-name" class="control-label">Team Name: </label>
                                <form:input cssStyle="height: 30px" path="name" id="team-name" type="text" name="name" value="${team.name}"/>
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
