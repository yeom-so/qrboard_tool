<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="${contextPath}/resources/js/login.js?ver=1.1&serviceUrl=<spring:eval expression="@serviceUrl['url']"/>"></script>
<script type="text/javascript">
    $(function(){
        LoginUtil.logoutSubmit();
    });
</script>
<div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="" onclick="LoginUtil.navToggle()">
            <span class="sr-only">Toggle menu</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <%--<a href="#" class="navbar-brand">${sessionScope.adminSession.name}님! 환영합니다.</a>--%>
        <c:if test="${currentMenu == 'templateShopList'}">
            <a href="${contextPath}/admin/templateManagement/templateShopList" class="navbar-brand"><spring:message code="menu.templateshop"/></a>
        </c:if>
        <c:if test="${currentMenu == 'templateManagement'}">
            <a href="${contextPath}/admin/templateManagement/templateList" class="navbar-brand"><spring:message code="menu.templatemanage"/></a>
        </c:if>
        <%--<c:if test="${currentMenu == 'schedule'}">--%>
            <%--<a href="${contextPath}/admin/schedule/scheduleList" class="navbar-brand">스케쥴관리</a>--%>
        <%--</c:if>--%>
        <c:if test="${currentMenu == 'templateGroupList'}">
            <a href="${contextPath}/admin/templateManagement/templateGroupList" class="navbar-brand"><spring:message code="menu.templategroup.manage"/></a>
        </c:if>
        <c:if test="${currentMenu == 'playlistManagement'}">
            <a href="${contextPath}/admin/playlistManagement/playlistList" class="navbar-brand"><spring:message code="menu.screenmanage"/></a>
        </c:if>
        <c:if test="${currentMenu == 'device'}">
            <a href="${contextPath}/admin/device/deviceList" class="navbar-brand"><spring:message code="menu.devicemanage"/></a>
        </c:if>
        <c:if test="${currentMenu == 'inquire'}">
            <a href="${contextPath}/admin/inquire/inquireRegist" class="navbar-brand"><spring:message code="menu.inquiry"/></a>
        </c:if>
        <c:if test="${currentMenu == 'userModify'}">
            <a href="${contextPath}/admin/setup/userModify" class="navbar-brand"><spring:message code="menu.changemyinfo"/></a>
        </c:if>
        <%--<c:if test="${currentMenu == 'scheduleRegist'}">--%>
            <%--<a href="${contextPath}/admin/schedule/scheduleRegist" class="navbar-brand">스케쥴 등록</a>--%>
        <%--</c:if>--%>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#" class="logout"><spring:message code="logout"/></a>
            </li>
        </ul>
    </div>
</div>
