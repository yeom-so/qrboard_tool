$(function(){
    $("#start, #end").datepicker({
		dateFormat: 'yy.mm.dd',
		showOn: "both",
		buttonImage: "./images/ads_calcendar.png",
		buttonImageOnly: true,
		monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'], //달력의 월 부분 텍스트
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //달력의 월 부분 Tooltip 텍스트
		dayNamesMin: ['일','월','화','수','목','금','토'], //달력의 요일 부분 텍스트
		dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
    });
	$("#ads .lists .opt_select").each(function(e){
		$("#ads .lists .opt_select").eq(e).click(function(){
			if($("#ads .lists .opt_view").eq(e).css("display")=="none"){
			$("#ads .lists .opt_select").removeClass("view");
			$("#ads .lists .opt_view").hide();
			$("#ads .lists .opt_select").eq(e).addClass("view");
			$("#ads .lists .opt_view").eq(e).show();
			}else{
			$("#ads .lists .opt_select").removeClass("view");
			$("#ads .lists .opt_view").hide();
			}
		});
	});
	$("#ads .lists .more").each(function(e){
		$("#ads .lists .more").eq(e).click(function(){
			if($("#ads .lists .contents").eq(e).css("display")=="none"){
			$("#ads .lists .contents").hide();
			$("#ads .lists .more").removeClass("view");
			$("#ads .lists .contents").eq(e).show();
			$("#ads .lists .more").eq(e).addClass("view");
			}else{
			$("#ads .lists .contents").hide();
			$("#ads .lists .more").removeClass("view");
			}
		});
	});
});
