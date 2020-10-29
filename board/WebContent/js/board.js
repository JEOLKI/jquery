/**
 * 
 */

currentpage = 1;

var updateboardServer = function() {
	
	$.ajax({
		url : '/board/Update',
		type : 'post',
		data : $('#uform').serialize(),
		success  : function(res) {
			//alert(res.sw);
			readpageServer(1);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})

}


var viewServer = function() {
	$.ajax({
	
		url : '/board/Update',
		type : 'get',
		data : { "seq" : idx },
		dataType : 'json',
		success : function(res) {
			
			
			$('#useq').val(res.seq);
			$('#usubject').val(res.subject);
			$('#uwriter').val(res.writer);
			
			//content =res.content.replace(/<br>/g, "\n");
			//$('#ucontent').val(content);

			$('#ucontent').val(res.content);
			$('#upassword').val(res.password);
			$('#umail').val(res.mail);
			
			$('#uModal').modal('show');
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
		
	})
	
}


var writeServer = function() {
	
	$.ajax({
	
		url : '/board/InsertBoard',
		data : $('#wform').serialize(),
		dataType : 'json',
		type : 'post',
		success : function(res) {
			//alert(res.sw);
			readpageServer(1);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
		
	})
	
}


var deleteServer = function(idx, button) {
	
	$.ajax({
		url : '/board/Delete',
		data : { "seq" : idx},
		type : 'post',
		dataType : 'json',
		success : function(res) {
			//alert(res.sw);
			$(button).parents('.panel').remove();
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
		
		
	})
	
	
}

var replyDeleteServer = function(idx, button) {
	
	$.ajax({
		url : '/board/ReplyDelete',
		data : { "redx" : idx},
		type : 'post',
		dataType : 'json',
		success : function(res) {
			//alert(res.sw);
			$(button).parents('.rep').remove();
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
		
		
	})
	
	
}


var replyUpdateServer = function() {
	
	$.ajax({
	
		url : '/board/ReplyUpdate',
		data : reply, //cont와 renum이 들어있다
		type : 'post',
		dataType : 'json',
		success : function(res) {
			alert(res.sw);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
		
		
	})
	
	
	
	
}



var replyListServer = function(button) {
	console.log("reply list = " + reply.bonum);
	
	$.ajax({
		data : { "bonum" : reply.bonum },
		url : '/board/ReplyList',
		type : 'get',
		dataType : 'json',
		success : function(res){
			
			$(button).parents('.panel').find('.rep').remove();

			repl = "";
			
			$.each(res, function(i,v) {
				
				repl += '    <div class="panel-body rep">';
				repl += '     <p style="float: left; width: 70%;">';
				repl += '     	<span>' + v.name + '&nbsp;&nbsp;&nbsp;&nbsp; ';
				repl +=           v.redate + '&nbsp;&nbsp;&nbsp;&nbsp;';
				repl += '       </span><br><br>';
				repl += '     	<span class="cont"> '+v.cont+' </span>';
				repl += '     </p>';
				repl += '     <p style="float: right; width: 20%;">';
				repl += '     	<input idx="'+ v.renum +'" type="button" name="r_modify" class="action" value="댓글수정">';
				repl += '     	<input idx="'+ v.renum +'" type="button" name="r_delete" class="action" value="댓글삭제">';
				repl += '     </p>';			
				repl += '</div>'

			})
			// parent는 바로위 부모만 parents는 조상모두 글제목눌럿을때는 바디를 찾기힘들기때문에 공통조상에 올라가서 내려오는방법을 이용한다. find 조상에서내려오는것
			
			
			$(button).parents('.panel').find('.pbody').append(repl);
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}
		
		
	}) 
	
}


var replySaveServer = function(button){
	
	// reply객체를 서버로 보낸다
	$.ajax({
		url : '/board/ReplySave',
		data : reply,
		type : 'post',
		success : function(res) {
			//alert(res.sw);
			replyListServer(button);
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
			
		},
		dataType : 'json'
		
	})
	
};

var readpageServer = function(cpage) {
	
	$.getJSON(
			'/board/ListPage',
			{ "page" : cpage },
			function(res) {
				
				$('.box').empty();
				
				code = '<div class="panel-group" id="accordion">';
				
				$.each(res.data, function(i,v) { //v를사용하지않으면 /*res.data[i].seq사용*/
				
					code += '<div class="panel panel-default">';
					code += '  <div class="panel-heading">';
					code += '    <h4 class="panel-title">';
				    code += '      <a idx="'+v.seq+'" class="action" name="list" data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.seq+'">'+v.subject+'</a>';
				    code += '    </h4>';
				    code += '  </div>';
				    code += '  <div id="collapse'+v.seq+'" class="panel-collapse collapse"> <!-- in이 있으면 처음에 펼쳐있다. -->';
				    code += '    <div class="panel-body pbody">';
				    code += '     <p style="float: left; width: 70%;">';
				    code += '     	작성자 : '+v.writer+' &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     	조회수 : '+v.hit+'	    &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     	메일 : '+v.mail+'   &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     	날짜 : '+v.wdate+'   &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     </p>';
				    code += '     <p style="float: right; width: 20%;">';
				    code += '     	<input idx="'+v.seq+'" type="button" name="modify" class="action" value="수정">';
				    code += '     	<input idx="'+v.seq+'" type="button" name="delete" class="action" value="삭제">';
				    code += '     </p>';
				    code += '     <hr>';
				    code += '     <p>';
				    code += 		v.content ;
				    code += '     </p>';
				    code += '     <p>';
				    code += '     	<textarea  cols="60"></textarea>';
				    code += '     	<input idx="'+v.seq+'" type="button" name="reply" id="enter" class="action" value="등록">';
				    code += '     </p>';
				    code += '    </div>';
				    code += '  </div>';
				    code += '</div>';
					
					
				})
				
				code += "</div>"
					
				$('.box').append(code);
				
				totalpage = res.tpage;
				startpage = res.spage;
				endpage = res.epage;
				currentpage = res.cpage;
				
				//이전 버튼 출력
				$('#btngroup1').empty();
				pager = "";
				if ( startpage > 1 ) {
					pager += '<ul class="pager">';
					pager += '  <li class="previous"><a href="#">Previous</a></li>';
					pager += '</ul>';
					$(pager).appendTo('#btngroup1');
				}
				
				//페이지 번호 출력
				
				pager = '<ul class="pagination pager">';
				for (i = startpage ; i <= endpage; i++) {
					
					if (currentpage == i) {
						pager += '<li class="active"><a class="paging" href="#">'+i+'</a></li>';
					}else {
						pager += '<li><a href="#" class="paging">'+i+'</a></li>';
					}
				}
				pager += '</ul>';
				$(pager).appendTo('#btngroup1');	
				
				
				//다음버튼 출력
				if(endpage < totalpage) {
					pager = '<ul class="pager">';
					pager += '  <li class="next" ><a href="#">Next</a></li>';
					pager += '</ul>';
					$(pager).appendTo('#btngroup1');	
				}
				
			}
	
	)
	
}



var readServer = function(cpage){ //페이지별 리스트를 하기위해서  html파일에엇 readServer(1), readServer(2), readServer(3)
	
	//$.getJSON(url, data, success) 단축메뉴 => 세개만 오는데 순서가 바뀌면 안된다.
	//$.get(url, data, success, dataType)
	
	$.getJSON(
			'/borad/ListAll',  // url    
			function(res) {     // success
				
				$('.box').empty();
				
				code = '<div class="panel-group" id="accordion">';
				$.each(res, function(i,v) {
				
					code += '<div class="panel panel-default">';
					code += '  <div class="panel-heading">';
					code += '    <h4 class="panel-title">';
				    code += '      <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.seq+'">'+v.subject+'</a>';
				    code += '    </h4>';
				    code += '  </div>';
				    code += '  <div id="collapse'+v.seq+'" class="panel-collapse collapse"> <!-- in이 있으면 처음에 펼쳐있다. -->';
				    code += '    <div class="panel-body">';
				    code += '     <p style="float: left; width: 70%;">';
				    code += '     	작성자 : '+v.writer+' &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     	조회수 : '+v.hit+'	    &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     	메일 : '+v.mail+'   &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     	날짜 : '+v.wdate+'   &nbsp;&nbsp;&nbsp;&nbsp;';
				    code += '     </p>';
				    code += '     <p style="float: right; width: 20%;">';
				    code += '     	<input type="button" name="modify" class="action" value="수정">';
				    code += '     	<input type="button" name="delete" class="action" value="삭제">';
				    code += '     </p>';
				    code += '     <hr>';
				    code += '     <p>';
				    code += 		v.content ;
				    code += '     </p>';
				    code += '     <p>';
				    code += '     	<textarea  cols="60"></textarea>';
				    code += '     	<input type="button" name="reply" class="action" value="등록">';
				    code += '     </p>';
				    code += '    </div>';
				    code += '  </div>';
				    code += '</div>';
					
					
				})
				
				code += "</div>"
					
				$('.box').append(code); // 그냥 append는 계속 페이지별리스트가 축적댐
				
				
				
				
			}
	)
	
	//-------------------------------------------------------------
	
	/* $.ajax({
		url : '/board/ListAll',
		type : 'get',
		dataType : 'json',
		success : function(res) {
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
	}) */
		
	
}