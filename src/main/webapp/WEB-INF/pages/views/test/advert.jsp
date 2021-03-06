<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    // 광고 등록
    function goQrbardAdvertCreate() {
        location.href = contextPath + "/user/advert/create";
    }
</script>

<div>
    <table border="1">
        <th>IDX</th>
        <th>광고상태</th>
        <th>광고명</th>
        <th>QR보드명</th>
        <th>광고기간</th>
        <th>등록일</th>
        <c:forEach items="${advertEntityList}" var="advertEntity">
            <tr>
                <td><a href="/user/advert/detail?advertIdx=${advertEntity.advertIdx}">${advertEntity.advertIdx}</a></td>
                <td>${advertEntity.advertState}</td>
                <td>${advertEntity.advertName}</td>
                <td>${advertEntity.qrboardName}</td>
                <td>${advertEntity.advertSdate} ~ ${advertEntity.advertEdate}</td>
                <td>${advertEntity.regDate}</td>
            </tr>
        </c:forEach>
    </table>

    <input type="button" value="광고 등록" onclick="goQrbardAdvertCreate();">
</div>
