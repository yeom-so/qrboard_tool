<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div>
    <table border="1">
        <th>IDX</th>
        <th>광고상태</th>
        <th>광고명</th>
        <th>QR보드명</th>
        <th>광고기간</th>
        <th>광고비</th>
        <th>결제일</th>
        <c:forEach items="${paymentEntityList.paymentPageEntityList}" var="paymentEntity">
            <tr>
                <td><a href="/user/payment/detail?advertIdx=${paymentEntity.advertIdx}">${paymentEntity.advertIdx}</a></td>
                <td>${paymentEntity.advertState}</td>
                <td>${paymentEntity.advertName}</td>
                <td>${paymentEntity.qrboardName}</td>
                <td>${paymentEntity.advertSdate} ~ ${paymentEntity.advertEdate}</td>
                <td>${paymentEntity.paymentPrice}</td>
                <td>${paymentEntity.regDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
