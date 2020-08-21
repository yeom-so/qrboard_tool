<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
</script>

<section id="join" class="page">
    <div class="logo">
        <a href="#"><img src="${contextPath}/resources/images/logo.png"/></a>
    </div>
    <div class="title">회원정보입력</div>
    <div class="desc">회원정보를 입력해 주세요.</div>
    <div class="form">
        <form action="login.html" onsubmit="return join_result()">
            <div class="frm_group">
                <div class="input_group">
                    <label>
                        <div class="v">이름</div>
                        <div class="in"><input type="text" id="name" class="inputs" placeholder="이름"/></div>
                    </label>
                </div>
                <div class="input_group no_bor">
                    <label>
                        <div class="v">연락처</div>
                        <div class="in"><input type="tel" id="tel" class="inputs" placeholder="010-1234-1234"/></div>
                    </label>
                </div>
                <div class="input_group">
                    <label>
                        <div class="v">아이디(이메일)</div>
                        <div class="in"><input type="email" id="id" class="inputs" placeholder="abcd@efghi.com"/></div>
                    </label>
                </div>
                <div class="input_group">
                    <label>
                        <div class="v">비밀번호</div>
                        <div class="in"><input type="password" id="pwd" class="inputs" placeholder="8자 이상"/></div>
                    </label>
                </div>
                <div class="input_group">
                    <label>
                        <div class="v">비밀번호 확인</div>
                        <div class="in"><input type="password" id="pwdre" class="inputs" required placeholder="다시한번 입력"/></div>
                    </label>
                </div>
            </div>
            <div class="desc2">
                영문  대/소문자, 숫자, 특수문자 중 3가지 이상을  <br/>
                조합하여 비밀번호를 입력해주세요
            </div>
            <button type="submit" class="btn btn_ok">회원가입</button>
            <button type="button" onclick="goBack(-2)" class="btn btn_cancal">취소</button>
        </form>
    </div>
</section>
