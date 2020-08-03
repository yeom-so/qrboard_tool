<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    // function login() {
    $(function(){
        $('#loginForm').ajaxForm({
            dateType: 'json',
            type: 'post',
            success: function (data) {
                if (typeof data == "string") data = JSON.parse(data);
                if (data.code == "Success") {
                    alert("로그인성공!!");
                } else {
                    alert(data.message);
                }
            },
            error: function () {
            }
        });
    });

    function test() {
        $.ajax({
            data: {userEmail: 'test'},
            type : "POST",
            dataType : "json",
            url : contextPath + "/userRest/test",
            success : function(){
                alert("성공");
            }
        });
    }
</script>

<script type="text/javascript">
</script>
<div class="loginWrap">
    <div class="outer">
        <div class="inner">
            <span class="title">로그인 페이지</span>
            <form id="loginForm" action="${contextPath}/userRest/loginUser" method="post">
                <input type="text" name="userEmail" value="erst"/><br/>
                <input type="password" name="userPw" value="1234" /><br/>
                <input type="submit" class="loginBtn" value="로그인"/>
            </form>
        </div>

        <input type="button" value="test" onclick="test()">
    </div>
</div>
