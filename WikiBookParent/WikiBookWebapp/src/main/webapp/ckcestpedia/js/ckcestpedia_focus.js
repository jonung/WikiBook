//获取查询的topic
var topicKey = decodeURI(document.location.href.split("=")[1]);
console.log(topicKey);

$.ajax({
		  type: "POST",
		  url: "/WikiBook/ckcestpedia/focusObtain",
		  data: { "topic":topicKey,"k":8}
		})
		  .done(function( msg ) {
			  console.log(msg);
			 var catalogInfo = eval("("+ msg.result+")");
			 console.log(catalogInfo);
			 
			 for(var i = 1; i <= catalogInfo.length; i ++) {
				 
				var item  = catalogInfo[i-1];
				var s='<dd class="catalog-item 0">'
						+'		<p class="z-catalog-i1">'
						+'		<span class="catalog-item-index1">'+i+'</span>'
						+'			<a href="#'+i+'"  >'+ item.focus +'</a>'
						+'		</p>'
						+'	</dd>';
					$(s).appendTo(".lie3");
				
				
				 
			 }
			 
			 
			 
		 });