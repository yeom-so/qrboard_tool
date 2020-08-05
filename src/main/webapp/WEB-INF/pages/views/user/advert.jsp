<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
    $(function(){
        // 광고등록
        $('#advertForm').ajaxForm({
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
</script>

<div>
    <form id="advertForm" action="${contextPath}/qrboardRest/certifyQrboardEntity" method="post">
        <input type="submit" value="QR보드 등록">
    </form>
    <br/>
    <table border="1">
        <th>IDX</th>
        <th>NAME</th>
    </table>
</div>
