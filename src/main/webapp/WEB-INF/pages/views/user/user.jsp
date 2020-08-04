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

    // QR보드관리
    function goQrboard() {
        location.href = contextPath + "/qrboard";
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
<input type="button" value="QR보드관리" onclick="goQrboard()">
