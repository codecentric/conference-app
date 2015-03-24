<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<table class="table table-striped visible-xs-block">
    <%@ include file="currentSessions_tableheader_small.html"%>
    <tbody class="">
        <c:forEach items="${sessions}" var="session">
            <c:url value="comments" var="url" scope="page">
                <c:param name="sessionId" value="${session.getId()}" />
            </c:url>
            <tr class="sessions" data-link="${url}">
                <td>${session.date}<br>${session.start} - ${session.end}</td>
                <td>${session.title}</td>
                <td>${session.author}</td>
                <td>${session.location}</td>
                <td><a class="btn btn-primary" href='comments?sessionId=${session.id}'>
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>