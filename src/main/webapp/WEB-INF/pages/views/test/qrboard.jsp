<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    $(function(){
        // QR보드등록
        $('#qrboardForm').ajaxForm({
            type : "POST"
            , dataType : "json"
            , success: function (data) {
                if (typeof data == "string") data = JSON.parse(data);
                alert(data.message);
                location.reload();
            },
            error: function () {
                alert(data.message);
            }
        });
    });

    // 레이아웃선택에 따른 기본템플릿 목록
    function changeLayoutIdx(layoutIdx) {
        $.ajax({
            data: {
                layoutIdx: layoutIdx
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/templateRest/selectTemplateEntityList',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                var options = '<option value="">기본템플릿선택</option>';
                for(var i=0; i<data.entityList.length; i++){
                    options += '<option value="'+ data.entityList[i].templateIdx +'">'+ data.entityList[i].templateName +'</option>';
                }
                $("#templateIdx").html(options);
            },
            error: function(){
                alert(data.message);
            }
        });
    }
</script>

<div>
    <form id="qrboardForm" action="${contextPath}/qrboardRest/certifyQrboardEntity" method="post">
        <input type="text" name="qrboardName" placeholder="QR보드명" value="로비1층"><br/>
        <input type="text" name="qrboardLocation" placeholder="주소검색에의한 위치" value="경기 안양시 동안구 흥안대로 427번길 57-2"><br/>
        <input type="text" name="qrboardDetailLocation" placeholder="상세위치" value="아이에스비즈타워"><br/>
        <input type="text" name="qrboardAutoLocation" placeholder="검색을위한 위치" value="경기 안양시 동안구 평촌동 160-1"><br/>
        <input type="text" name="qrboardAuthNum" placeholder="인증번호" value="ABCD1234"><br/>
        <input type="text" name="qrboardPermitNum" placeholder="허가번호" value="AA001"><br/>
        <select name="layoutIdx" onchange="changeLayoutIdx(this.value)">
            <option value="">레이아웃선택</option>
            <c:forEach items="${layoutEntityList}" var="layoutEntity">
                <option value="${layoutEntity.layoutIdx}">${layoutEntity.layoutName}</option>
            </c:forEach>
        </select><br/>
        <select name="templateIdx" id="templateIdx">
            <option value="">기본템플릿선택</option>
        </select><br/>
        <input type="text" name="qrboardPrice" placeholder="광고단가" value="1000"><br/>
        <select name="qrboardPublicYn">
            <option value="Y">허용</option>
            <option value="N">불허</option>
        </select><br/>
        <select name="qrboardApproveYn">
            <option value="Y">승인시만 광고게시</option>
            <option value="N">미승인시도 광고게시</option>
        </select><br/>
        <input type="text" name="qrboardApproveStime" placeholder="광고승인 가능 시작시간" value="0900"><br/>
        <input type="text" name="qrboardApproveEtime" placeholder="광고승인 가능 종료시간" value="1800"><br/>
        <select name="qrboardApproveOption">
            <option value="1">결제후 1시간이내 미승인시 자동게시</option>
            <option value="2">결제후 1시간이내 미승인시 자동취소</option>
        </select><br/>
        <input type="submit" value="QR보드 등록">
    </form>
    <br/>
    <table border="1">
        <th>IDX</th>
        <th>QR보드명</th>
        <th>레이아웃</th>
        <th>빈광고영역</th>
        <th>허가번호</th>
        <th>광고단가</th>
        <c:forEach items="${qrboardEntityList}" var="qrboardEntity">
            <tr>
                <td><a href="/user/qrboard/detail?qrboardIdx=${qrboardEntity.qrboardIdx}">${qrboardEntity.qrboardIdx}</a></td>
                <td>${qrboardEntity.qrboardName}</td>
                <td>${qrboardEntity.layoutName}</td>
                <td>${qrboardEntity.qrboardAreaNum - qrboardEntity.advertNum}</td>
                <td>${qrboardEntity.qrboardPermitNum}</td>
                <td>${qrboardEntity.qrboardPrice}</td>
            </tr>
        </c:forEach>
    </table>
</div>
