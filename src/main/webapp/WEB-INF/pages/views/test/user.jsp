<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    $(function(){
        // 내정보변경
        $('#userForm').ajaxForm({
            type : "POST"
            , dataType : "json"
            , success: function (angularResultEntity) {
                if (typeof angularResultEntity == "string") angularResultEntity = JSON.parse(angularResultEntity);
                alert(angularResultEntity.message);
                location.reload();
            },
            error: function () {
                alert(angularResultEntity.message);
            }
        });
    });

    // 유료회원변경
    function updatePayUserEntity() {
        $.ajax({
            data : {
                userIdx : ${sessionScope.user.userIdx},
            }
            , type : "POST"
            , dataType : "json"
            , url : contextPath + "/userRest/updatePayUserEntity"
            , success : function(angularResultEntity){
                alert(angularResultEntity.message);
                location.reload();
            }
            , error : function(angularResultEntity){
                alert(angularResultEntity.message);
            }
        });
    }

    // 로그아웃
    function logout() {
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: contextPath +'/userRest/logout',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                if(data.code == "Success"){
                    location.href = contextPath + data.url;
                }else{
                    alert(data.message);
                }
            },
            error: function(){
                alert(data.message);
            }
        });
    }

    // 광고관리
    function goAdvert() {
        location.href = contextPath + "/user/advert";
    }

    // QR보드 보기
    function goQrbardAdvert() {
        location.href = contextPath + "/user/qrboard/advert";
    }

    // 결제관리
    function goPayment() {
        location.href = contextPath + "/user/payment";
    }

    // QR보드관리
    function goQrboard() {
        location.href = contextPath + "/admin/qrboard";
    }

    // 광고승인관리
    function goAdvertApprove() {
        location.href = contextPath + "/admin/advert/approve";
    }

    // 내광고관리
    function goAdvertMy() {
        location.href = contextPath + "/admin/advert/my";
    }

    // 결제관리
    function goPaymentMy() {
        location.href = contextPath + "/admin/payment/my";
    }
</script>

<div>
    <input type="button" value="로그아웃" onclick="logout()">
    <br/><br/>
    <form id="userForm" action="${contextPath}/userRest/updateUserEntity" method="post">
        <input type="text" name="userIdx" value="${sessionScope.user.userIdx}"><br/>
        <input type="text" name="userName" value="${sessionScope.user.userName}"><br/>
        <input type="text" name="userTel" value="${sessionScope.user.userTel}"><br/>
        <input type="text" name="userEmail" value="${sessionScope.user.userEmail}" disabled><br/>
        <input type="text" name="userPw" value=""><br/>
        <input type="submit" value="내정보변경">
        <input type="button" value="유료회원변경" onclick="updatePayUserEntity()">
    </form>
</div>
<br/>
<c:if test="${sessionScope.user.userGrade == 2}">
    <input type="button" value="광고사업주 - QR보드관리" onclick="goQrboard()"><br/>
    <input type="button" value="광고사업주 - 광고승인관리" onclick="goAdvertApprove()"><br/>
    <input type="button" value="광고사업주 - 결제관리" onclick="goPaymentMy()"><br/>
    <input type="button" value="광고사업주 - 내광고관리" onclick="goAdvertMy()"><br/>
</c:if>
<c:if test="${sessionScope.user.userGrade == 3}">
    <input type="button" value="광고주 - 광고관리" onclick="goAdvert()"><br/>
    <input type="button" value="광고주 - QR보드보기" onclick="goQrbardAdvert()"><br/>
    <input type="button" value="광고주 - 결제관리" onclick="goPayment()"><br/>
</c:if>
