<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="top">
    <a href="/user/main" class="home"><img src="${contextPath}/resources/images/ads_home.png"/></a>
    <div class="ttl">
        <c:if test="${currentMenu=='mypage'}">내정보변경</c:if>
        <c:if test="${currentMenu=='advert'}">광고관리</c:if>
        <c:if test="${currentMenu=='qrboard'}">QR보드보기</c:if>
        <c:if test="${currentMenu=='payment'}">결제관리</c:if>
    </div>
</div>
