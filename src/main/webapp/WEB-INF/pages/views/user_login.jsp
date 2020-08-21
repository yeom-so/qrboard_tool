<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    $(function(){
        $('#loginForm').ajaxForm({
            beforeSerialize: function() {
                if($("#userEmail").val() == ''){
                    alert("아이디(이메일)을 입력해주세요.");
                    return false;
                }
                if($("#userPw").val() == ''){
                    alert("비밀번호를 입력해주세요.");
                    return false;
                }
            },
            type : "POST"
            , dataType : "json"
            , success: function (data) {
                if (typeof data == "string") data = JSON.parse(data);
                if (data.code == "Success") {
                    location.href = contextPath + data.url;
                } else {
                    alert(data.message);
                }
            }
            , error: function () {
                alert(data.message);
            }
        });
    });
</script>

<div id="wrap" class="w100">
    <section id="login" class="page">
        <div class="logo">
            <a href="#"><img src="${contextPath}/resources/images/logo.png"/></a>
        </div>
        <div class="title">광고 관리툴</div>
        <div class="use">
            광고주용
            <span class="v">v1.0</span>
        </div>
        <div class="form">
            <form id="loginForm" action="${contextPath}/userRest/login" method="post">
                <input type="hidden" name="userGrade" value="3"> <%-- 사용자타입고정 (3: 광고주) --%>

                <%if(request.getServerName().equals("127.0.0.1")){%>
                <div class="input_group">
                    <input type="text" name="userEmail" class="inputs userEmail" placeholder="아이디(이메일)" value="test"/>
                </div>
                <div class="input_group">
                    <input type="password" name="userPw" class="inputs userPw" placeholder="비밀번호" value="1234"/>
                </div>
                <%}else{%>
                <div class="input_group">
                    <input type="text" name="userEmail" class="inputs userEmail" placeholder="아이디(이메일)"/>
                </div>
                <div class="input_group">
                    <input type="password" name="userPw" class="inputs userPw" placeholder="비밀번호"/>
                </div>
                <%}%>

                <div class="chk_group chk2">
                    <label><input type="checkbox" id="login_auto">로그인 상태 유지</label>
                </div>
                <button type="submit" class="btn_login">로그인</button>
                <div class="link1">
                    <a href="/user/term" class="join">회원가입</a>
                    <a class="find">아이디/비밀번호찾기</a>
                </div>
            </form>
        </div>
        <div class="copy kopub">2020 QRBOARD All RIGHTS RESERVED</div>
    </section>
</div>
