function submitThisMessage(){
	var n =  $('#name').val();
	var e =  $('#email').val();
	var s =  $('#subject').val();
	var m =  $('#message').val();
	
	if(n.length > 0 && e.length > 0 && s.length > 0 && m.length > 0){
		var XMLHttpRequestObject = false;
		if (window.XMLHttpRequest) {
			XMLHttpRequestObject = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			XMLHttpRequestObject = new
			ActiveXObject("Microsoft.XMLHTTP");
		}		
		if(XMLHttpRequestObject) {
			
			XMLHttpRequestObject.open("POST", "/STSC/Controller?name="+ $('#name').val() + "&email=" + $('#email').val() + "&subject=" + $('#subject').val() + "&message=" + $('#message').val());
			XMLHttpRequestObject.onreadystatechange = function(){
				if (XMLHttpRequestObject.readyState == 4 &&	XMLHttpRequestObject.status == 200) {			
					$("#thxMessage").attr("class", "text-success");
					$('#thxMessage').html(n + " your message has been sent. Thanks for the feedback.");
				}else{
					$("#thxMessage").attr("class", "text-error");
					$('#thxMessage').html(n + " your message was not sent, there is an issue, please report this to the webmaster@entry-guard.com.");
					
				}
			};
			XMLHttpRequestObject.send(null);
		}
		$('#name').val("");
		$('#email').val("");
		$('#subject').val("");
		$('#message').val("");
	}else{
		$("#thxMessage").attr("class", "text-warning");
		$('#thxMessage').html("All values below are required to submit message.");
	}
}

$(document).ready(function(){	
	//default usage
	$("#name").charCount({
		allowed: 50,		
		warning: 20,
		counterText: 'Characters left: '	
	});
	$("#email").charCount({
		allowed: 30,		
		warning: 20,
		counterText: 'Characters left: '	
	});
	$("#subject").charCount({
		allowed: 30,		
		warning: 20,
		counterText: 'Characters left: '	
	});
	$("#message").charCount({
		allowed: 245,		
		warning: 20,
		counterText: 'Characters left: '	
	});
});

(function($) {

	$.fn.charCount = function(options){
	  
		// default configuration properties
		var defaults = {	
			allowed: 140,		
			warning: 25,
			css: 'counter',
			counterElement: 'span',
			cssWarning: 'warning',
			cssExceeded: 'exceeded',
			counterText: ''
		}; 
			
		var options = $.extend(defaults, options); 
		
		function calculate(obj){
			var count = $(obj).val().length;
			var available = options.allowed - count;
			if(available <= options.warning && available >= 0){
				$(obj).next().addClass(options.cssWarning);
			} else {
				$(obj).next().removeClass(options.cssWarning);
			}
			if(available < 0){
				$(obj).next().addClass(options.cssExceeded);
			} else {
				$(obj).next().removeClass(options.cssExceeded);
			}
			$(obj).next().html(options.counterText + available);
		};
				
		this.each(function() {  			
			$(this).after('<'+ options.counterElement +' class="' + options.css + '">'+ options.counterText +'</'+ options.counterElement +'>');
			calculate(this);
			$(this).keyup(function(){calculate(this)});
			$(this).change(function(){calculate(this)});
		});
	  
	};

})(jQuery);