$(function(){
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
