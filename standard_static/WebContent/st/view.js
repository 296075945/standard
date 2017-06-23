$(document).ready(function(){ 
	updateView(url);
})

function updateView(url){
	$.ajax({
		url:url,
		dataType:"jsonp",
		jsonp:"callbackparam",
		success:function(data){
			alert(data.standard.id);
		}
	});
}