
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <div class="header">
<nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
    <span class="navbar-toggler-icon leftmenutrigger"></span>
    <a class="navbar-brand" href="#">Dota Stats</a>
    <ul class="navbar-nav animate side-nav">
        <li class="nav-item">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/team">Add Team</a>
        </li>
        <li class="nav-item">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/league">Add League</a>
        </li>
        <li class="nav-item">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/stats">Statistic</a>
        </li>
        <li class="nav-item">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/formula">Profit Formula</a>
        </li>
    </ul>
</nav>
        </div>
</body>
</html>
