<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="sidebar-wrapper">
    <div class="logo">
        <a href="${contextPath}/admin/templateManagement/templateList" class="simple-text">
            <%-- 스마트플랫인경우 logo icon visible--%>
            <%if(request.getServerName().equals("makesflat.co.kr")){%>
                <img src="${contextPath}/resources/img/admin/logo-icon.png" alt="" width="20px" height="20px">
            <%}%>
            <spring:message code="title"/>
        </a>
    </div>
    <div class="userInfo">
        <p><strong>${sessionScope.adminSession.name}</strong><spring:message code="welcome"/></p>
        <p>
            <span>
                <a href="${contextPath}/admin/setup/userModify">
                    <i class="pe-7s-id"></i>
                    <spring:message code="menu.changemyinfo"/>
                </a>
            </span>
            <span class="empty-space"></span>
            <span>
                <a href="#" class="logout">
                    <i class="pe-7s-unlock"></i>
                    <spring:message code="logout"/>
                </a>
            </span>
        </p>
    </div>
    <ul class="nav">
        <li <c:if test="${currentMenu=='templateShopList'}">class="active"</c:if>>
            <a href="${contextPath}/admin/templateManagement/templateShopList">
                <i class="pe-7s-gift"></i>
                <p><spring:message code="menu.templateshop"/></p>
            </a>
        </li>
        <li <c:if test="${currentMenu=='templateManagement'}">class="active"</c:if>>
            <a href="${contextPath}/admin/templateManagement/templateList">
                <i class="pe-7s-note2"></i>
                <p><spring:message code="menu.templatemanage"/></p>
            </a>
        </li>
        <li <c:if test="${currentMenu=='templateGroupList'}">class="active"</c:if>>
            <a href="${contextPath}/admin/templateManagement/templateGroupList">
                <i class="pe-7s-photo-gallery"></i>
                <p><spring:message code="menu.templategroup.manage"/></p>
            </a>
        </li>
        <!-- 2016-04-19 스케쥴 기능 개발 중단으로 인한 메뉴 비활성화 -->
        <!-- 관리툴 스케쥴 기능은 완료되었고, 추후 기능 필요시 주석 해제만 하면 됨 -->
        <%--<li <c:if test="${currentMenu=='schedule'}">class="active"</c:if>>--%>
            <%--<a href="${contextPath}/admin/schedule/scheduleList">--%>
                <%--<i class="pe-7s-date"></i>--%>
                <%--<p>스케쥴관리</p>--%>
            <%--</a>--%>
        <%--</li>--%>
        <li <c:if test="${currentMenu=='playlistManagement'}">class="active"</c:if>>
            <a href="${contextPath}/admin/playlistManagement/playlistList">
                <i class="pe-7s-film"></i>
                <p><spring:message code="menu.screenmanage"/></p>
            </a>
        </li>
        <li <c:if test="${currentMenu=='device'}">class="active"</c:if>>
            <a href="${contextPath}/admin/device/deviceList">
                <i class="pe-7s-config"></i>
                <p><spring:message code="menu.devicemanage"/></p>
            </a>
        </li>
        <li <c:if test="${currentMenu=='inquire'}">class="active"</c:if>>
            <a href="${contextPath}/admin/inquire/inquireRegist">
                <i class="pe-7s-call"></i>
                <p><spring:message code="menu.inquiry"/></p>
            </a>
        </li>
        <%if(request.getServerName().equals("makesflat.co.kr")){%>
            <li>
                <a href="https://drive.google.com/file/d/1ylc7BAWSBTKscKwB3z0m9k43vmEOC-V-/view" target="_blank">
                    <p><spring:message code="menu.manual"/></p>
                </a>
            </li>
            <li>
                <a href="https://drive.google.com/file/d/0BzOa4rtPyC0WZ0ppdU8zTklYWWs/view" target="_blank">
                    <p><spring:message code="menu.sample"/></p>
                </a>
            </li>
        <%}%>
    </ul>
    <%if(request.getServerName().equals("makesflat.co.kr")){%>
        <script type="text/javascript" src="https://partner.talk.naver.com/banners/script"></script>
        <div class="talk_banner_div" data-id="19506" style="text-align:center; margin-top: 20px;"></div>
    <%}%>
</div>



<%--<div class="sidebar-background" style="display:block;background-image:url(${contextPath}/resources/img/admin/nav-background.jpg);"></div>--%>
<div class="sidebar-background" style="display:block;"></div>
