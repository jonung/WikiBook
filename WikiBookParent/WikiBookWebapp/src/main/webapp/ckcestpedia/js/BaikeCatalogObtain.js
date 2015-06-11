
var key = decodeURI(document.location.href.split("=")[1]);
$.ajax({
		  type: "POST",
		  url: "/KnGraph/ckcestpedia/baikeCatalogSearch",
		  data: { "searchKey":key,"focusK":8}
		  //data: { "searchKey":key,"searchTopic":topic}
		})
		  .done(function( msg ) {
			 var catalogInfo = eval("("+ msg.result+")");
			// console.log(catalogInfo);
			 
			 for(var i = 1; i <= catalogInfo.length; i ++) {
				 
				 var item  = catalogInfo[i-1];
				 var s='<dd class="catalog-item 0">'
						+'		<p class="z-catalog-i1">'
						+'		<span class="catalog-item-index1">'+i+'</span>'
						+'			<a href="#'+i+'"  >'+ item.hypernym +'</a>'
						+'		</p>'
						+'	</dd>';
					$(s).appendTo(".lie3");
				
				var hyponym = item.hyponym;
				 for(var j = 1; j <= hyponym.length; j ++) {
					 var s='<dd class="catalog-item 0">'
							+'		<p class="z-catalog-i1">'
							+'		<span class="catalog-item-index1">'+ i +"."+ j+'</span>'
							+'			<a href="#'+i+'"  >'+ hyponym[j-1] +'</a>'
							+'		</p>'
							+'	</dd>';
						$(s).appendTo(".lie3");
				 }
				 
			 }
			 
			 var content = "";
			 
			 for(var i = 1; i < catalogInfo.length; i ++) {
				 var item  = catalogInfo[i-1];
				 console.log(item);
				 var hyponym = item.hyponym;
				 if(hyponym.length == 0) {
					 $.ajax({
						 	async: false,
						  type: "POST",
						  url: "/KnGraph/ckcestpedia/catalogContentSearch",
						  data: { "searchCatalog":item.hypernym}
						  //data: { "searchKey":key,"searchTopic":topic}
						})
						  .done(function( msg ) {
							  //console.log(msg);
							  //var cc = eval("("+ msg.result+")");
							  var cc = msg.result;
							  
							  content =
								  '<div class="content">'
								  +'			<div class="anchor-list">'
								  +'				<a name="'+i+'" ></a>'
								  +'			</div>'
								  +'			<h2 class="headline-1">'
								  +'				<span class="headline-1-index">'+i+'</span>'
								  +'				<span class="headline-content">'+item.hypernym+'</span>'
								  +'				</span>'
								  +'			</h2>'
								  +'			<div class="para"><span >'+cc+'</span> '
								  +'				<div class="text_pic layoutright" data-layout="center" style="width:100%;padding-left: 30%">'
								  +'				<a class="nslog:1200 pic-handle" title="查看图片" href="" target="_blank">&nbsp;&nbsp;</a>'
								  +'				<img style="width:300px" src='+ msg.imgUrl+'>'
								  +'				<p class = "para" style="width:100%;padding-left: 15%" >'	
								  +'				<br>'
								  +					item.hypernym
								  +'				</br>'
								  +'				</p>'
								  +'				<a name="ref_[1]_3314"></a>'				
								  +'				</div>'
								  +'			</div>'
								  +'		</div>';
							  $(content).appendTo(".catalog");
						  });
				 }
				 else {
					 for(var j = 1; j <= hyponym.length; j ++) {
						 var hkey = hyponym[j-1];
						 console.log("hkey" + hkey);
						 $.ajax({
							 async: false,
							  type: "POST",
							  url: "/KnGraph/ckcestpedia/catalogContentSearch",
							  data: { "searchCatalog":hkey}
							 
							})
							  .done(function( msg ) {
								  console.log("msg.result" + msg.result);
								  
								 // var cc = eval("("+ msg.result+")");
								  var cc = msg.result;
								  content=
									  '<div class="content">'
									  +'			<div class="anchor-list">'
									  +'				<a name="'+i+'" ></a>'
									  +'			</div>'
									  +'			<h2 class="headline-1">'
									  +'				<span class="headline-1-index">'+i+'.'+j+'</span>'
									  +'				<span class="headline-content">'+hkey+'</span>'
									  +'				</span>'
									  +'			</h2>'
									  +'			<div class="para"><span >'+cc+'</span> '
									  +'				<div class="text_pic layoutright" data-layout="right" style="width:220px;padding-left: 20px">'
									  +'				<a class="nslog:1200 pic-handle" title="查看图片" href="" target="_blank">&nbsp;&nbsp;</a>'
									  +'				<img style="width:200px" src='+ msg.imgUrl+'>'
									  +					hkey
									  +'				<a name="ref_[1]_3314"></a>'				
									  +'				</div>'
									  +'			</div>'
									  +'		</div>';
								  $(content).appendTo(".catalog");
							  });
						 
					 }
				 }
				 
			 }
			// $(".catalog").append(content);
			 
		  });