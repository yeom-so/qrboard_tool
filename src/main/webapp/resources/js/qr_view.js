$(document).ready(function() {
	$("#ads .btn_ads").each(function(e){
		$("#ads .btn_ads").eq(e).click(function(){
			$("#ads .btn_ads").removeClass("view");
			$("#ads .btn_ads").eq(e).addClass("view");
		});
	});
})