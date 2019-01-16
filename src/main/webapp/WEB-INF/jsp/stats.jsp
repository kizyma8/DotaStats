<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kizyma8
  Date: 02/12/18
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="stats">
<head>
    <title>Stats</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.no-icons.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/lib/jquery.select2.css">
    <link rel="stylesheet" href="/resources/css/style.css">

    <%--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>--%>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/lib/jquery-3.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/lib/jquery-ui-1.11.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/lib/jquery.select2.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</head>
<body>
<%@ include file="layout/header.jsp" %>
<div class="modal-body-stats">
    <form:form name="create" method="post" action="/stats" modelAttribute="stats" ng-controller="StatsCtrl">
        <div class="form-group">
                                <span>
                                <label style="margin-left: 10px; width: 150px" for="team-select" class="control-label">Select Team:</label>
                                <form:select id="team-select" cssClass="select-team" cssStyle="width: 200px" name="teamId" multiple="false"
                                             path="teams">
                                    <form:options items="${stats.teams}"
                                                  itemValue="dotaId"
                                                  itemLabel="name"/>
                                </form:select>
                                </span>
            <span>
                                <label style="margin-left: 10px; width: 150px" for="team-select2" class="control-label">Select Team:</label>
                                <form:select id="team-select2" cssClass="select-team" cssStyle="width: 200px" name="teamId2" multiple="false"
                                             path="teams2">
                                    <form:option selected="selected" value="" label="--- Select ---"/>
                                    <form:options items="${stats.teams}"
                                                  itemValue="dotaId"
                                                  itemLabel="name"/>
                                </form:select>
                                </span>
        </div>

        <div class="form-group">
                <span>
                    <label style="margin-left: 10px; width: 150px" for="league-select" class="control-label">Select League:</label>
                <form:select  id="league-select" cssClass="select-league" cssStyle="width: 200px" multiple="false" path="leagues">
                    <form:option selected="true" value="" label="--- Select ---"/>
                    <form:options items="${stats.leagues}" itemLabel="name" itemValue="leagueId"/>
                </form:select>
                </span>
        </div>
        <div class="form-group">
                <span>
                    <label style="margin-left: 10px; width: 150px" for="date-select" class="control-label">Start search from:</label>
                    <input id="date-select" name="date"  type="date" ng-model="date" style="width: 200px" title="Start Date"/>
                </span>
        </div>
        <div class="form-group">
                <span>
                    <label style="margin-left: 10px; width: 150px" for="kill-point" class="control-label">Total kills more:</label>
                    <input id="kill-point" name="totalKills" style="width: 200px" title="Kill Point"/>
                </span>
        </div>
        <div class="form-group">
                <span>
                    <label style="margin-left: 10px; width: 150px" for="kill-point" class="control-label">Total time more:</label>
                    <input id="timeDuration" name="totalTime" style="width: 200px" title="Total time more"/>
                </span>
        </div>
        <div class="form-group">
                <span>
                    <label style="margin-left: 10px; width: 150px" for="fbInclude"  class="control-label">Include FB stats:</label>
                    <input  type="checkbox" id="fbInclude" name="fbInclude" style="width: 200px" title="Total time more"/>
                </span>
        </div>
        <span><button class="btn btn-danger" type="submit" value="Submit">Submit</button></span>
    </form:form>
</div>
</body>
</html>
