<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!newsList.isEmpty()}">
    <div class="container-fluid">
        <div class="bs-callout bs-callout-warning" id="callout-glyphicons-accessibility">
            <h4>News</h4>
            <ul>
                <c:forEach items="${newsList}" var="news">
                    <span class="bg-info"><c:out value="${news.text}" /></span><br/>
                </c:forEach>
            </ul>
        </div>
    </div>
</c:if>