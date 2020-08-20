$(document).ready(function() {
	$(".gal_list a").each(function(e){
		$(".gal_list a").eq(e).click(function(){
			$(".gal_list a").removeClass("view");
			$(".gal_list a").eq(e).addClass("view");
			$("#temNm").val($(".gal_list a").eq(e).attr('data-temNm'));
		});
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
});