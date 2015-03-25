<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<div class="accordion visible-xs-block" id="accordion2">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <c:forEach items="${sessions}" var="session">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading${session.id}">
                    <div class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#${session.id}" aria-expanded="false"
                               aria-controls="${session.id}">
                        <div>
                                    ${session.date} ${session.start} - ${session.end}
                                    <h4>${session.title}</h4>
                                    ${session.location}
                        </div>
                            </a>
                    </div>
                </div>
                <div id="${session.id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${session.id}">
                    <div class="panel-body row">
                        <div class="col-xs-8">${session.author}</div>
                        <div class="col-xs-4">
                            <a class="btn btn-primary pull-right" href='comments?sessionId=${session.id}'>
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>