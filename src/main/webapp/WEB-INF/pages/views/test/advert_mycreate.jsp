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

    // 광고타입 변경
    function changeAdvertType(type) {
        if(type == 'N') {
            $("#advertPublic").css('display', 'none');
            $("#advertNormal").css('display', 'block');
        }else{
            $("#advertPublic").css('display', 'block');
            $("#advertNormal").css('display', 'none');
        }
    }

    // 업종별템플릿 선택
    function changeTemplateShopIdx(templateShopIdx) {
        // 템플릿 상세 정보 가져오기
        $.ajax({
            data: {
                templateShopIdx: templateShopIdx
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

    // 공용광고 선택
    function changePublicAdvertIdx(publicAdvertIdx) {
        // 템플릿 상세 정보 가져오기
        $.ajax({
            data: {
                publicAdvertIdx: publicAdvertIdx
            },
            dataType: 'json',
            type: 'post',
            url: contextPath +'/publicAdvertRest/selectPublicAdvertEntity',
            success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                bindingEntity(data.entity);
                $("#advertName").val(data.entity.publicAdvertName);
                $("#advertProfit").val(data.entity.publicAdvertProfit);
            },
            error: function(){
                alert(data.message);
            }
        });
    }

    function insertAdvertEntity() {
        advertEntity.qrboardIdx = $("#qrboardIdx").val();
        advertEntity.qrboardAreaIdx = $("#qrboardAreaIdx").val();
        advertEntity.templateShopIdx = $("#templateShopIdx").val();
        advertEntity.publicAdvertIdx = $("#publicAdvertIdx").val();
        advertEntity.advertType = $("#advertType").val();
        advertEntity.advertName = $("#advertName").val();
        advertEntity.advertUserName = $("#adverUserName").val();
        advertEntity.advertUserCi = $("#advertUserCi").val();
        advertEntity.advertUserTel = $("#advertUserTel").val();
        advertEntity.advertSdate = $("#advertSdate").val();
        advertEntity.advertEdate = $("#advertEdate").val();
        advertEntity.advertPrice = $("#advertPrice").val();
        advertEntity.advertProfit = $("#advertProfit").val();
        advertEntity.advertState = 4;

        $.ajax({
            data : JSON.stringify(advertEntity)
            , type : "POST"
            , dataType : "json"
            , contentType : "application/json"
            , url : contextPath + "/advertRest/insertAdvertEntity"
            , success: function(data){
                if(typeof data == "string") data = JSON.parse(data);
                alert(data.message);
                location.reload();
            }
            , error: function(){
                alert(data.message);
            }
        });
    }

</script>

<div>
    <select id="advertType" onchange="changeAdvertType(this.value)">
        <option value="N">일반광고</option>
        <option value="P">공익광고</option>
    </select><br/>
    <input type="text" id="qrboardIdx" placeholder="QR보드 인덱스" value="${qrboardAreaEntity.qrboardIdx}"><br/>
    <input type="text" id="qrboardName" placeholder="QR보드명" value="${qrboardAreaEntity.qrboardName}"><br/>
    <input type="text" id="qrboardAreaIdx" placeholder="QR보드 영역 인덱스" value="${qrboardAreaEntity.qrboardAreaIdx}"><br/>
    <input type="text" id="qrboardAreaSeq" placeholder="광고영역" value="${qrboardAreaEntity.qrboardAreaSeq}"><br/>
    <input type="text" id="userName" placeholder="광고사업자명" value="${qrboardAreaEntity.userEmail}"><br/>
    <input type="text" id="userTel" placeholder="광고사업자전화번호" value="${qrboardAreaEntity.userTel}"><br/>
    <input type="text" id="layoutName" placeholder="레이아웃명" value="${qrboardAreaEntity.layoutName}"><br/>

    <div id="advertNormal">
        <input type="text" id="templateIdx" placeholder="QR보드 기본템플릿 인덱스" value="${qrboardAreaEntity.templateIdx}"><br/>
        <select id="templateShopIdx" onchange="changeTemplateShopIdx(this.value)">
            <option value="">업종템플릿선택</option>
            <c:forEach items="${templateShopEntityList}" var="templateShopEntity">
                <option value="${templateShopEntity.templateShopIdx}">${templateShopEntity.templateShopName}</option>
            </c:forEach>
        </select><br/>
        <input type="text" id="advertPrice" placeholder="광고료"><br/>
    </div>
    <div id="advertPublic" style="display: none;">
        <select id="publicAdvertIdx" onchange="changePublicAdvertIdx(this.value)">
            <option value="">공용광고선택</option>
            <c:forEach items="${publicAdvertEntityList}" var="publicAdvertEntity">
                <option value="${publicAdvertEntity.publicAdvertIdx}">${publicAdvertEntity.publicAdvertName}</option>
            </c:forEach>
        </select><br/>
        <input type="text" id="advertProfit" placeholder="광고수익금"><br/>
    </div>

    <input type="text" id="advertName" placeholder="광고명"><br/>
    <input type="text" id="advertSdate" placeholder="광고시작일" value="${qrboardAreaEntity.advertEdate}"><br/>
    <input type="text" id="advertEdate" placeholder="광고종료일"><br/>

    <div class="content-wrap"></div>

    <input type="button" value="저장" onclick="insertAdvertEntity();">
</div>
