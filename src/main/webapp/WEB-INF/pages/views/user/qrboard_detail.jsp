<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    $(function(){
        // QR보드수정
        $('#qrboardForm').ajaxForm({
            type : "POST"
            , dataType : "json"
            , success: function (angularResultEntity) {
                if (typeof angularResultEntity == "string") angularResultEntity = JSON.parse(angularResultEntity);
                alert(angularResultEntity.message);
                location.href = contextPath + "/user/qrboard";
            },
            error: function () {
                alert(angularResultEntity.message);
            }
        });
    });

    function deleteQrboardEntity(qrboardIdx) {
        $.ajax({
            data: {
                qrboardIdx: qrboardIdx
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/qrboardRest/deleteQrboardEntity',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                alert(data.message);
            },
            error: function(){
                alert(data.message);
            }
        });
    }
</script>

<div>
    <form id="qrboardForm" action="${contextPath}/qrboardRest/updateQrboardEntity" method="post">
        <input type="text" name="qrboardIdx" value="${qrboardEntity.qrboardIdx}"><br/>
        <input type="text" name="qrboardName" placeholder="QR보드명" value="${qrboardEntity.qrboardName}"><br/>
        <input type="text" name="qrboardLocation" placeholder="주소검색에 의한 위치" value="${qrboardEntity.qrboardLocation}"><br/>
        <input type="text" name="qrboardDetailLocation" placeholder="상세위치" value="${qrboardEntity.qrboardDetailLocation}"><br/>
        <input type="text" name="qrboardAutoLocation" placeholder="검색을 위한 위치" value="${qrboardEntity.qrboardAutoLocation}"><br/>
        <input type="text" name="layoutIdx" value="${qrboardEntity.layoutIdx}"><br/>
        <input type="text" name="templateIdx" value="${qrboardEntity.templateIdx}"><br/>
        <input type="text" name="qrboardPrice" placeholder="광고단가" value="1000"><br/>
        <input type="text" name="qrboardPublicYn" value="${qrboardEntity.qrboardPublicYn}"><br/>
        <input type="text" name="qrboardApproveYn" value="${qrboardEntity.qrboardApproveYn}"><br/>
        <input type="text" name="templateIdx" value="${qrboardEntity.templateIdx}"><br/>
        <input type="text" name="qrboardApproveStime" placeholder="광고승인 가능 시작시간" value="${qrboardEntity.qrboardApproveStime}"><br/>
        <input type="text" name="qrboardApproveEtime" placeholder="광고승인 가능 종료시간" value="${qrboardEntity.qrboardApproveEtime}"><br/>
        <input type="text" name="qrboardApproveOption" value="${qrboardEntity.qrboardApproveOption}"><br/>
        <input type="text" value="${qrboardEntity.regDate}"><br/>
        <input type="text" value="" placeholder="광고진행현황"><br/>
        <input type="submit" value="QR보드 수정">
    </form>
    <br/>
    <input type="button" value="QR보드 삭제" onclick="deleteQrboardEntity(${qrboardEntity.qrboardIdx})">
</div>
