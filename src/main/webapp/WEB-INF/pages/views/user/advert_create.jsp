<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    var advertEntity = {
        advertIdx : -1
        , qrboardIdx : -1
        , qrboardAreaIdx : -1
        , contentIdx : -1
        , templateShopIdx : -1
        , advertType : null
        , advertName : null
        , advertUserName : null
        , advertUserCi : null
        , advertUserTel : null
        , advertSdate : null
        , advertEdate : null
        , advertPrice : 0
        , advertProfit : 0
        , advertPayYn : 'Y'
        , advertState : 2
        , contentTextEntityList : []
        , contentImageEntityList : []
        , contentBackgroundEntityList : []
    };

    // QR보드 선택
    function selectQrboardIdx(qrboardIdx) {
        $.ajax({
            data: {
                qrboardIdx: qrboardIdx
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/qrboardAreaRest/selectQrboardAreaEntityList',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                var options = '<option value="">QR보드영역선택</option>';
                for(var i=0; i<data.entityList.length; i++){
                    if(data.entityList[i].lastAdvertEdate == null){
                        options += '<option value="'+ data.entityList[i].qrboardAreaIdx +'">광고등록</option>';
                    }else{
                        options += '<option value="'+ data.entityList[i].qrboardAreaIdx +'">광고예약('+ data.entityList[i].lastAdvertEdate+' 이후 가능)</option>';
                    }
                }
                $("#selectQrboardAreaIdx").html(options);
                $("#qrboardIdx").val(qrboardIdx);
            },
            error: function(){
                alert(data.message);
            }
        });
    }

    // 광고영역 선택
    function changeQrboardAreaIdx(qrboardAreaIdx) {
        // qrboard 상세 정보 가져오기
        $.ajax({
            data: {
                qrboardIdx: $("#qrboardIdx").val()
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/qrboardRest/selectQrboardEntity',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                $("#qrboardName").val(data.entity.qrboardName);
                $("#templateIdx").val(data.entity.templateIdx);
                $("#userName").val(data.entity.userName);
                $("#userTel").val(data.entity.userTel);
                $("#layoutName").val(data.entity.layoutName);
                $("#qrboardApproveStime").val(data.entity.qrboardApproveStime);
                $("#qrboardApproveEtime").val(data.entity.qrboardApproveEtime);

                // 업종별 템플릿 목록
                getTemplateShopList(data.entity.templateIdx);
            },
            error: function(){
                alert(data.message);
            }
        });
        $("#qrboardAreaIdx").val(qrboardAreaIdx);
    }

    // 업종별템플릿 목록
    function getTemplateShopList(templateIdx) {
        $.ajax({
            data: {
                templateIdx: templateIdx
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/templateShopRest/selectTemplateShopEntityList',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                var options = '<option value="">업종템플릿선택</option>';
                for(var i=0; i<data.entityList.length; i++){
                    options += '<option value="'+ data.entityList[i].templateShopIdx +'">'+ data.entityList[i].templateShopName +'</option>';
                }
                $("#templateShopIdx").html(options);
            },
            error: function(){
                alert(data.message);
            }
        });
    }

    // 업종별템플릿 선택
    function changeTemplateShopIdx(templateShopIdx) {
        // 템플릿 상세 정보 가져오기
        $.ajax({
            data: {
                templateShopIdx: $("#templateShopIdx").val()
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/templateShopRest/selectTemplateShopEntity',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                bindingEntity(data.entity);
            },
            error: function(){
                alert(data.message);
            }
        });
    }

    // 업종템플릿 선택 후 리턴받은 콘텐츠 데이터
    function bindingEntity(obj) {
        advertEntity.contentTextEntityList = obj.contentTextEntityList;
        advertEntity.contentImageEntityList = obj.contentImageEntityList;
        advertEntity.contentBackgroundEntityList = obj.contentBackgroundEntityList;

        // 텍스트 콘텐츠
        var temp = '';
        for(var i=0; i<advertEntity.contentTextEntityList.length; i++){
            var contentTextEntity = advertEntity.contentTextEntityList[i];
            temp += '<input type="text" value="'+ contentTextEntity.contentText +'"><br/>';
        }
        $(".content-wrap").append(temp);

        // 이미지 콘텐츠
        var temp = '';
        for(var i=0; i<advertEntity.contentImageEntityList.length; i++){
            var contentImageEntity = advertEntity.contentImageEntityList[i];
            if(contentImageEntity.contentImageGroupIdx == 0){
                temp += '<div id="contentImageWrap-'+ contentImageEntity.contentImageIdx +'"></div>';
                $(".content-wrap").append(temp);
            }else{
                var imageTemp = '<input type="text" value="'+ contentImageEntity.contentImagePath +'">';
                $("#contentImageWrap-"+contentImageEntity.contentImageGroupIdx).append(imageTemp);
            }
        }

        // 배경 콘텐츠
        var temp = '';
        for(var i=0; i<advertEntity.contentBackgroundEntityList.length; i++){
            var contentBackgroundEntity = advertEntity.contentBackgroundEntityList[i];
            temp += '<input type="text" value="'+ contentBackgroundEntity.contentBackgroundColor +'"><br/>';
        }
        $(".content-wrap").append(temp);
    }

    // 결제
    function pay() {
        IMP.request_pay({
            pg : 'html5_inicis', // version 1.1.0부터 지원.
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            amount : 1000,
            buyer_email : '',
            // name : '주문명:결제테스트',
            // m_redirect_url : 'https://www.yourdomain.com/payments/complete'
        }, function(rsp) {
            if ( rsp.success ) {

                // 광고 등록
                advertEntity.qrboardIdx = $("#qrboardIdx").val();
                advertEntity.qrboardAreaIdx = $("#qrboardAreaIdx").val();
                advertEntity.templateShopIdx = $("#templateShopIdx").val();
                advertEntity.advertType = $("#advertType").val();
                advertEntity.advertName = $("#advertName").val();
                advertEntity.advertUserName = $("#adverUserName").val();
                advertEntity.advertUserCi = $("#advertUserCi").val();
                advertEntity.advertUserTel = $("#advertUserTel").val();
                advertEntity.advertSdate = $("#advertSdate").val();
                advertEntity.advertEdate = $("#advertEdate").val();
                advertEntity.advertPrice = $("#advertPrice").val();
                advertEntity.advertPayYn = $("#advertPayYn").val();
                advertEntity.paymentEntity = {
                    impUid: rsp.imp_uid,
                    merchantUid: rsp.merchant_uid,
                    paymentPrice: rsp.paid_amount,
                    paymentTid: rsp.pg_tid,
                    paymentMethod: rsp.pay_method,
                    paymentApplNum: rsp.apply_num,
                    paymentCardNum: rsp.card_number,
                    paymentCardName: rsp.card_name,
                    paymentOs: 'P',
                    paymentStatus: rsp.status
                };

                $.ajax({
                    data : JSON.stringify(advertEntity)
                    , type : "POST"
                    , dataType : "json"
                    , contentType : "application/json"
                    , url : contextPath + "/advertRest/insertAdvertEntity"
                    , success: function(data){
                        if(typeof data == "string") data = JSON.parse(data);
                        alert(data.message);
                    }
                    , error: function(){
                        alert(data.message);
                    }
                });
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                alert(msg);
            }
        });
    }

    // 결제취소테스트
    function payCancel() {
        // TOKEN 받아오기
        $.ajax({
            data: {
                impUid : 'imp_235563597657',
                merchantUid: 'merchant_1597835563473'
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/advertRest/cancelPayment',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
            },
            error: function(){
                alert(data.message);
            }
        });
    }
</script>

<div>
    <table border="1">
        <th>IDX</th>
        <th>NAME</th>
        <c:forEach items="${qrboardEntityList}" var="qrboardEntity">
            <tr>
                <td><a href="#" onclick="selectQrboardIdx(${qrboardEntity.qrboardIdx})">${qrboardEntity.qrboardIdx}</a></td>
                <td>${qrboardEntity.qrboardName}</td>
            </tr>
        </c:forEach>
    </table>
    <select id="selectQrboardAreaIdx" onchange="changeQrboardAreaIdx(this.value)">
        <option>QR보드영역선택</option>
    </select>
    <br/>
    <input type="text" id="qrboardIdx" placeholder="QR보드 인덱스"><br/>
    <input type="text" id="qrboardName" placeholder="QR보드명" readonly><br/>
    <input type="text" id="qrboardAreaIdx" placeholder="QR보드 영역 인덱스"><br/>
    <input type="text" id="qrboardAreaSeq" placeholder="광고영역" readonly><br/>
    <input type="text" id="templateIdx" placeholder="QR보드 기본템플릿 인덱스"><br/>
    <select id="templateShopIdx" onchange="changeTemplateShopIdx(this.value)">
        <option value="">업종템플릿선택</option>
    </select><br/>
    <input type="text" id="userName" placeholder="광고사업자명" readonly><br/>
    <input type="text" id="userTel" placeholder="광고사업자전화번호" readonly><br/>
    <input type="text" id="layoutName" placeholder="레이아웃명" readonly><br/>
    <input type="text" id="qrboardApproveStime" placeholder="광고심사시작시간"><br/>
    <input type="text" id="qrboardApproveEtime" placeholder="광고심사종료시간"><br/>
    <select id="advertType">
        <option value="N">일반광고</option>
        <option value="P">공익광고</option>
    </select><br/>
    <input type="text" id="advertName" placeholder="광고명"><br/>
    <input type="text" id="advertUserName" placeholder="본인인증 이름"><br/>
    <input type="text" id="advertUserCi" placeholder="본인인증 키"><br/>
    <input type="text" id="advertUserTel" placeholder="본인인증 번호"><br/>
    <input type="text" id="advertSdate" placeholder="광고시작일"><br/>
    <input type="text" id="advertEdate" placeholder="광고종료일"><br/>
    <input type="text" id="advertPrice" placeholder="광고료"><br/>
    <select id="advertPayYn">
        <option value="Y">결제완료</option>
        <option value="N">미결제</option>
    </select><br/>
    <div class="content-wrap"></div>
    <input type="button" value="광고 등록" onclick="pay();">
</div>
