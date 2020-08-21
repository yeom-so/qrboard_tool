<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="lists">
    <div class="desc">광고를 등록하고 관리합니다.</div>
    <form>
        <div class="dates">
            <div class="f">기간</div>
            <div class="in">
                <input type="text" id="start" readonly>
            </div>
            <div class="in in2">
                <input type="text" id="end" readonly>
            </div>
        </div>
        <div class="searchs">
            <input type="search" class="sear">
            <button type="submit" class="sear_btn"><img src="${contextPath}/resources/images/ads_search.png"/></button>
        </div>
    </form>
    <div class="list-in">
        <table cellspacing="0">
            <colgroup>
                <col width="20%"/>
                <col width="30%"/>
                <col width="30%"/>
                <col width="20%"/>
            </colgroup>
            <thead>
            <tr>
                <th>순번</th>
                <th><a class="opt_select">광고상태<img src="${contextPath}/resources/images/ads_arraw.png" class="arraw"/></a>
                    <div class="opt_view opt1">
                        <a>전체</a>
                        <a>접수</a>
                        <a>승인대기중</a>
                        <a>승인</a>
                        <a>진행중</a>
                        <a>완료</a>
                    </div>
                </th>
                <th><a class="opt_select">광고순<img src="${contextPath}/resources/images/ads_arraw.png" class="arraw"/></a>
                    <div class="opt_view opt2">
                        <a>가나다</a>
                        <a>abc</a>
                        <a>최신순</a>
                        <a>과거순</a>
                    </div>
                </th>
                <th>더보기</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>접수</td>
                <td class="tit"><a href="ad_view.html">세일행사</a></td>
                <td class="more">
                    <a class="plus"><img src="${contextPath}/resources/images/ads_plus.png"/></a>
                    <a class="minus"><img src="${contextPath}/resources/images/ads_minus.png"/></a>
                </td>
            </tr>
            <tr class="contents">
                <td colspan="4" class="type1">
                    <div class="r">
                        <div class="t_b">QR보드명</div>
                        <div class="t_c">가산동001-STX V타워 1층 로비</div>
                        <div class="t_b">기간</div>
                        <div class="t_c c2">7일</div>
                    </div>
                    <div class="r">
                        <div class="t_b">광고시작</div>
                        <div class="t_c">2020.12.31</div>
                        <div class="t_b">결제액</div>
                        <div class="t_c c2">3,500원</div>
                    </div>
                    <div class="r">
                        <div class="t_b">광고종료</div>
                        <div class="t_c">2020.12.31</div>
                        <div class="t_b">결제상태</div>
                        <div class="t_c c2">결제완료</div>
                    </div>
                    <div class="r">
                        <div class="t_b">등록일</div>
                        <div class="t_c c3">2020.12.31</div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="paging">
        <a class="prev">&lt;</a>
        <a class="next">&gt;</a>
        1<span class="bold">/10</span>
    </div>
</div>
