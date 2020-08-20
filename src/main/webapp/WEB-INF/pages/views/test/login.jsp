<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    $(function(){
        $('#loginForm').ajaxForm({
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

        $('#joinForm').ajaxForm({
            type : "POST"
            , dataType : "json"
            , success: function (data) {
                if (typeof data == "string") data = JSON.parse(data);
                alert(data.message);
            }
            , error: function () {
                alert(data.message);
            }
        });
    });
</script>

<div class="loginWrap">
    <div class="outer">
        <div class="inner">
            <form id="loginForm" action="${contextPath}/userRest/login" method="post">
                <input type="text" name="userEmail" value="erst"/><br/>
                <input type="password" name="userPw" value="1234" /><br/>
                <input type="submit" value="로그인"/>
            </form>
            <br/>
            <form id="joinForm" action="${contextPath}/userRest/insertUserEntity" method="post">
                <select name="userGrade">
                    <option value="2">광고사업자</option>
                    <option value="3">광고주</option>
                </select><br/>
                <input type="text" name="userName" placeholder="이름"><br/>
                <input type="text" name="userTel" placeholder="전화번호"><br/>
                <input type="text" name="userEmail" placeholder="이메일"><br/>
                <input type="text" name="userPw" placeholder="비밀번호"><br/>
                <input type="submit" value="회원가입"/>
            </form>
        </div>
    </div>
</div>
