<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    //회원가입 약관 동의체크
    function chk_agree(){
        if(!$("#chk_all").is(":checked")){
            alert('사용약관에 동의해주세요.');
        }else{
            goPage("/user/join");
        }
    }
</script>

<section id="join_agree" class="page">
    <div class="logo">
        <a href="#"><img src="${contextPath}/resources/images/logo.png"/></a>
    </div>
    <div class="title">약관동의</div>
    <div class="desc">QR보드 사용을 위해 약관에 동의해주세요.</div>
    <div class="form">
        <div class="box">
            개인정보처리방침
            <a class="more">[보기]</a>
        </div>
        <div class="box">
            서비스 이용약관
            <a class="more">[보기]</a>
        </div>
        <div class="box">
            개인정보 수집 및 이용동의
            <a class="more">[보기]</a>
        </div>
        <div class="chk_group">
            <label><input type="checkbox" id="chk_all">모두 동의합니다.</label>
        </div>
        <button type="button" onclick="chk_agree()" class="btn btn_next">다음</button>
        <button type="button" onclick="goBack(-1)" class="btn btn_cancal">취소</button>
    </div>
</section>
