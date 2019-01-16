<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Base</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.no-icons.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%@ include file="layout/header.jsp" %>
<div class="container">
    <div class="resume">
        <c:choose>
            <c:when test="${durationDto.secondTeamName != null}">
                <header class="page-header">
                    <h1 class="page-title">${durationDto.teamName} vs ${durationDto.secondTeamName}</h1>
                    <small>Getting stats by all matches for this two teams, not just their meeting</small>
                </header>
            </c:when>
            <c:otherwise>
                <header class="page-header">
                    <h1 class="page-title">${durationDto.teamName}</h1>
                    <small>Stats by ${durationDto.teamName} team</small>
                </header>
            </c:otherwise>
        </c:choose>

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8">
                <div class="panel panel-default">
                    <div class="panel-heading resume-heading">
                        <div class="row">

                        </div>
                    </div>
                    <div class="bs-callout bs-callout-danger">
                        <h4>Match Count </h4><br/>
                        <h2 style="text-align: center">
                        <span class="align-elements">${durationDto.matchCountTeam2 > 0 ? durationDto.matchCountTeam1 : ""}</span>
                        <span class="align-elements">${durationDto.matchCount}</span>
                        <span class="align-elements">${durationDto.matchCountTeam2 > 0 ? durationDto.matchCountTeam2 : ""}</span>
                        </h2>
                    </div>
                    <div class="bs-callout bs-callout-danger">
                        <h4>Average match duration (minutes): </h4>
                        <h2 style="text-align: center">
                            <span class="align-elements">${durationDto.durationTeam2 > 0 ? durationDto.durationTeam1 : ""}</span>
                            <span class="align-elements">${durationDto.duration}</span>
                            <span class="align-elements">${durationDto.durationTeam2 > 0 ? durationDto.durationTeam2 : ""}</span>
                        </h2>
                    </div>
                    <div class="bs-callout bs-callout-danger">
                        <h4>Average Kills: </h4>
                        <h2 style="text-align: center;/*margin-left: -35px*/">
                            <span class="align-elements" style="display: ${killsDto.killsTeam2 > 0 ? "" : "none"}">${killsDto.killsTeam1}</span>
                            <span class="align-elements" >${killsDto.kills}</span>
                            <span class="align-elements" style="display: ${killsDto.killsTeam2 > 0 ? "" : "none"}">${killsDto.killsTeam2}</span>
                        </h2>
                    </div>
                    <c:if test="${killsDto.totalKills > 0}">
                    <div class="bs-callout bs-callout-danger">
                        <h4>Total more ${killsDto.totalKills} kills: </h4>
                        <h2 style="text-align: center;/*margin-left: -35px*/">
                            <span class="align-elements" id="kils_team1" style="display: ${killsDto.totalKillsPercentTeam2 > 0 ? "" : "none"}">${killsDto.totalKillsPercentTeam1}%</span>
                            <span class="align-elements">${killsDto.totalKillsPercent}%</span>
                            <span class="align-elements" id="kils_team2" style="display: ${killsDto.totalKillsPercentTeam2 > 0 ? "" : "none"}">${killsDto.totalKillsPercentTeam2}%</span>
                        </h2>
                    </div>
                    </c:if>
                    <c:if test="${durationDto.specifiedDuration > 0}">
                        <div class="bs-callout bs-callout-danger">
                            <h4>Total more ${durationDto.specifiedDuration} minutes (%): </h4>
                            <h2 style="text-align: center">
                                <span class="align-elements" id="duration_team1" style="display: ${durationDto.higherThenSpecifiedTeam2 > 0 ? "" : "none"}">${durationDto.higherThenSpecifiedTeam1}%</span>
                                <span class="align-elements">${durationDto.durationHigherThenSpecified}%</span>
                                <span class="align-elements" id="duration_team2" style="display: ${durationDto.higherThenSpecifiedTeam2 > 0 ? "" : "none"}">${durationDto.higherThenSpecifiedTeam2}%</span>
                            </h2>
                        </div>
                    </c:if>

                        <div class="bs-callout bs-callout-danger">
                            <h4>Courier Kills: </h4>
                            <h2 style="text-align: center"><span>${killsDto.couriersKills}%</span> </h2>
                        </div>

                    <c:if test="${killsDto.firstTeamFBPercent > 0}">
                        <div class="bs-callout bs-callout-danger">
                            <h4>First Blood: </h4>
                            <h2 style="text-align: center"><span>${killsDto.firstTeamFBPercent}%</span>
                            <c:if test="${killsDto.secondTeamFBPercent > 0}">
                                <span>VS ${killsDto.secondTeamFBPercent}%</span>
                            </c:if>
                            </h2>
                        </div>
                    </c:if>
                </div>

            </div>
        </div>

    </div>

</div>
</body>
</html>
