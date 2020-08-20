<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    // 광고 승인여부 설정
    function updateAdvertState() {
        $.ajax({
            data: {
                advertIdx: $("#advertIdx").val(),
                advertState: $("#approveYn").val() == 'Y' ? 4:1,
                advertStateBigo: $("#advertStateBigo").val()
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/advertRest/updateAdvertState',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                alert(data.message);
                location.reload();
            },
            error: function(){
                alert(data.message);
            }
        });
    }
</script>

<div>
    <input type="text" id="advertIdx" placeholder="광고 인덱스" value="${advertEntity.advertIdx}"><br/>
    <input type="text" id="qrboardIdx" placeholder="QR보드 인덱스" value="${advertEntity.qrboardIdx}"><br/>
    <input type="text" id="qrboardName" placeholder="QR보드명" value="${advertEntity.qrboardName}"><br/>
    <input type="text" id="qrboardAreaSeq" placeholder="광고영역" value="${advertEntity.qrboardAreaSeq}"><br/>
    <input type="text" id="templateName" placeholder="QR보드 기본템플릿 이름" value="${advertEntity.templateName}"><br/>
    <input type="text" id="templateShopName" placeholder="QR보드 업종템플릿 이름" value="${advertEntity.templateShopName}"><br/>
    <input type="text" id="userEmail" placeholder="광고사업자명" value="${advertEntity.userEmail}"><br/>
    <input type="text" id="userTel" placeholder="광고사업자전화번호" value="${advertEntity.userTel}"><br/>
    <input type="text" id="layoutName" placeholder="레이아웃명" value="${advertEntity.layoutName}"><br/>
    <input type="text" id="advertName" placeholder="광고명" value="${advertEntity.advertName}"><br/>
    <input type="text" id="qrboardApproveStime" placeholder="광고심사시작시간" value="${advertEntity.qrboardApproveStime}"><br/>
    <input type="text" id="qrboardApproveEtime" placeholder="광고심사종료시간" value="${advertEntity.qrboardApproveEtime}"><br/>
    <input type="text" id="advertUserCi" placeholder="본인인증" value="${advertEntity.advertUserName}"><br/>
    <input type="text" id="advertUserCi" placeholder="본인인증" value="${advertEntity.advertUserCi}"><br/>
    <input type="text" id="advertUserTel" placeholder="본인인증" value="${advertEntity.advertUserTel}"><br/>
    <input type="text" id="advertSdate" placeholder="광고시작일" value="${advertEntity.advertSdate}"><br/>
    <input type="text" id="advertEdate" placeholder="광고종료일" value="${advertEntity.advertEdate}"><br/>
    <input type="text" id="advertPrice" placeholder="광고료" value="${advertEntity.advertPrice}"><br/>
    <input type="text" id="advertState" placeholder="광고상태" value="${advertEntity.advertState}"><br/>
    <c:if test="${advertEntity.advertState == 1}">
        <input type="text" id="advertState" placeholder="결제취소일" value="${advertEntity.paymentCancelDate}"><br/>
    </c:if>
    <c:if test="${sessionScope.user.userGrade == 2}">
        <c:if test="${advertEntity.advertState == 2}">
            <select id="approveYn">
                <option value="Y">승인</option>
                <option value="N">미승인</option>
            </select>
            <br/>
            <textarea id="advertStateBigo" placeholder="미승인 사유"></textarea><br/>
            <input type="button" value="저장" onclick="updateAdvertState();">
        </c:if>
    </c:if>

    <br/>
    <c:forEach items="${advertEntity.contentTextEntityList}" var="contentTextEntity">
        <input type="text" value="${contentTextEntity.contentText}"><br/>
    </c:forEach>
    <c:forEach items="${advertEntity.contentImageEntityList}" var="contentImageEntity">
        <input type="text" value="${contentImageEntity.contentImagePath}"><br/>
    </c:forEach>
    <c:forEach items="${advertEntity.contentBackgroundEntityList}" var="contentBackgroundEntity">
        <input type="text" value="${contentBackgroundEntity.contentBackgroundColor}"><br/>
    </c:forEach>
    <br/>

</div>
