<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    // 로그아웃
    function logout() {
        // TODO: CONFIRM 추가
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
</script>

<div id="wrap">
    <section id="main" class="page">
        <div class="logo">
            <a href="/user/main"><img src="${contextPath}/resources/images/logo.png"/></a>
        </div>
        <div class="title">광고 관리툴</div>
        <div class="msg"><span class="bold">홍길동</span>님 환영합니다.</div>
        <div class="links">
            <a href="join2.html" class="first">정보변경</a>
            <a href="#" onclick="logout()">로그아웃</a>
        </div>
        <div class="boxs">
            <div class="col-b b1">
                <img src="${contextPath}/resources/images/main_01.png"/>
                <div class="ttl">광고관리</div>
            </div>
            <div class="col-b b2">
                <img src="${contextPath}/resources/images/main_02.png"/>
                <div class="ttl">QR보드 보기</div>
            </div>
            <div class="col-b b3">
                <img src="${contextPath}/resources/images/main_03.png"/>
                <div class="ttl">결제관리</div>
            </div>
        </div>
        <div class="copy kopub">2020 QRBOARD All RIGHTS RESERVED</div>
    </section>

</div>
