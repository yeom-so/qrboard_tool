<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
</script>

<div>
    <table border="1">
        <th>IDX</th>
        <th>QR보드명</th>
        <th>광고사업자</th>
        <th>레이아웃</th>
        <th>빈광고영역</th>
        <th>내광고여부</th>
        <c:forEach items="${qrboardEntityList}" var="qrboardEntity">
            <tr>
                <td><a href="/qrboard/advert_detail?qrboardIdx=${qrboardEntity.qrboardIdx}">${qrboardEntity.qrboardIdx}</a></td>
                <td>${qrboardEntity.qrboardName}</td>
                <td>${qrboardEntity.userEmail}</td>
                <td>${qrboardEntity.layoutName}</td>
                <td>${qrboardEntity.qrboardAreaNum - qrboardEntity.advertNum}</td>
                <td>${qrboardEntity.advertState}</td>
            </tr>
        </c:forEach>
    </table>
</div>
