<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
</script>

<div>
    <c:forEach var="qrboardAreaEntity" items="${qrboardAreaEntityList}">
        <div style="border: 5px solid yellowgreen;">
            <c:if test="${qrboardAreaEntity.contentIdx == 0}">
                광고없음
            </c:if>
            <c:if test="${qrboardAreaEntity.contentIdx != 0}">
                ${qrboardAreaEntity.qrboardAreaIdx}<br/>
                ${qrboardAreaEntity.qrboardAreaSeq}<br/>
                ${qrboardAreaEntity.lastAdvertSdate}<br/>
                ${qrboardAreaEntity.lastAdvertEdate}<br/>
                ${qrboardAreaEntity.contentTextEntityList}<br/>
                ${qrboardAreaEntity.contentImageEntityList}<br/>
                ${qrboardAreaEntity.contentBackgroundEntityList}
            </c:if>
        </div>
    </c:forEach>
</div>
