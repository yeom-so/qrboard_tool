<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div>
    <input type="text" id="advertIdx" placeholder="광고 인덱스" value="${paymentEntity.advertIdx}"><br/>
    <input type="text" id="qrboardName" placeholder="QR보드명" value="${paymentEntity.qrboardName}"><br/>
    <input type="text" id="qrboardAreaSeq" placeholder="광고영역" value="${paymentEntity.qrboardAreaSeq}"><br/>
    <input type="text" id="templateName" placeholder="QR보드 기본템플릿 이름" value="${paymentEntity.templateName}"><br/>
    <input type="text" id="templateShopName" placeholder="QR보드 업종템플릿 이름" value="${paymentEntity.templateShopName}"><br/>
    <input type="text" id="userEmail" placeholder="광고사업자명" value="${paymentEntity.userEmail}"><br/>
    <input type="text" id="userTel" placeholder="광고사업자전화번호" value="${paymentEntity.userTel}"><br/>
    <input type="text" id="layoutName" placeholder="레이아웃명" value="${paymentEntity.layoutName}"><br/>
    <input type="text" id="advertName" placeholder="광고명" value="${paymentEntity.advertName}"><br/>
    <input type="text" id="advertSdate" placeholder="광고시작일" value="${paymentEntity.advertSdate}"><br/>
    <input type="text" id="advertEdate" placeholder="광고종료일" value="${paymentEntity.advertEdate}"><br/>
    <input type="text" id="advertPrice" placeholder="광고료" value="${paymentEntity.paymentPrice}"><br/>
    <input type="text" id="paymentCardName" placeholder="결제수단" value="${paymentEntity.paymentCardName}"><br/>
    <input type="text" id="advertState" placeholder="광고상태" value="${paymentEntity.advertState}"><br/>
</div>
