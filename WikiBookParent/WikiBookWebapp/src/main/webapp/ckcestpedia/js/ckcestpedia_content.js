//获取查询的topic
var topicKey = decodeURI(document.location.href.split("=")[1]);
//console.log(topicKey);

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
				 
				var focus  = catalogInfo[i-1].focus;
				
				$.ajax({
						 async: false,
						  type: "POST",
						  url: "/WikiBook/ckcestpedia/focusContent",
						  data: { "keyword":focus}
						 
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
								  +'				<span class="headline-1-index">'+i+'</span>'
								  +'				<span class="headline-content">'+focus+'</span>'
								  +'				</span>'
								  +'			</h2>'
								  +'			<div class="para"><span >'+cc+'</span> '
								  +'				<div class="text_pic layoutright" data-layout="right" style="width:220px;padding-left: 20px">'
								  +'				<a class="nslog:1200 pic-handle" title="查看图片" href="" target="_blank">&nbsp;&nbsp;</a>'
								  +'				<img style="width:200px" src='+ msg.imgUrl+'>'
								  +					focus
								  +'				<a name="ref_[1]_3314"></a>'				
								  +'				</div>'
								  +'			</div>'
								  +'		</div>';
							  $(content).appendTo(".catalog");
						  });

				
				 
			 }
			 
			 
			 
		 });