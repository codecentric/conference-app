<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

 <table class="table table-striped hidden-xs">
    <%@ include file="currentSessions_tableheader.html"%>
    <c:forEach items="${sessions}" var="session">
        <c:url value="comments" var="url" scope="page">
            <c:param name="sessionId" value="${session.getId()}" />
        </c:url>
        <tr class="sessions" data-link="${url}">
            <td>${session.date}</td>
            <td>${session.start}</td>
            <td>${session.end}</td>
            <td>${session.title}</td>
            <td>${session.author}</td>
            <td>${session.location}</td>
            <td><a class="btn btn-primary" href='comments?sessionId=${session.id}'>Comment</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>