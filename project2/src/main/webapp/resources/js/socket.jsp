<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">
	let sock = new SockJS("http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/echo");
	let id = null;
	let member = null;
	let myno = null;
	let first = false;
	let server = null;
	let mainDom = document.querySelector('.chat-List > ul')
	
	sock.onopen = function ons() {
		let ons = JSON.parse(sessionStorage.getItem("ons"));
		if(ons != null){
			join(ons.k, 1, ons.name);
		}		
	} 		
	
	
	function sendMessage() {
	    sock.send($("#send-box").val());
	    $('#send-box').val('')
	}
	
	function on() {
		if(first){
			$.ajax({
				url:"${pageContext.request.contextPath}/createRoom",
				data:{id:id},
				type:"POST",
				success: function sc(s) {
					myno = s;
					sendMessage();											
				}					
			})
		}else{
			sendMessage();					
		}
	}

	function join(id,type,name) {
		console.log(id)
		$.ajax({
	 		url:"${pageContext.request.contextPath}/jointwo",
	 		type:"POST",
	 		data:{id:id,type:type},
	 		success: function sc(s) {
				if(s == '')first = true;
				mainDom.innerHTML = '';
				server = s.room_no;
				let Dom = inList.querySelector("#k"+server);
				if(Dom != null && Dom.children[1].className == "tag green"){
					Dom.children[1].className = "tag";
					chatNum(--newNum);
				}
				
				if(!first){
					member = s.member;
					let chat = s.chat;
					myno = s.my_other_no;
					
					chat.forEach(c => {
						let time = IntToTime(c.SENT)
						
						let mytf = c.CHAT_OTHER_NO == myno;
						let newLi = document.createElement('li');
						newLi.setAttribute("class", mytf ? "you" : "me");
						newLi.innerHTML = '<div class="chat-thumb"><img src="${finalPath}resources/images/resources/chatlist2.jpg" alt=""></div><div class="notification-event"><span class="chat-message-item">'+c.DETAIL+'</span><span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">'+time+'</time></span></div>';
						mainDom.appendChild(newLi);
					})
					$('.chat-List > ul').scrollTop($('.chat-List > ul').prop('scrollHeight'));
				} 
				
				
				
				let chatBox = document.querySelector('.chat-box');
				chatBox.querySelector('h6').innerText = name;
				$('.chat-box').addClass("show");
				if(sessionStorage.getItem("ons") == null || sessionStorage.getItem("ons").k != server){
					let sj =  {k:server , name : name};
					sessionStorage.setItem("ons",JSON.stringify(sj));					
				}
			}
	 	}) 
	}
	
	$('.close-mesage').on('click', function() {
		$.ajax({
			url:"${pageContext.request.contextPath}/close",
			type:"POST"
		})
		$('.chat-box').removeClass("show");
		server = null;
		sessionStorage.setItem("ons", null);
		return false;
	});	
	
		
	sock.onmessage = function(e){
		let chat = JSON.parse(e.data);
		let mytf = chat.CHAT_OTHER_NO == myno;
		let k = chat.roomserver;
		
		let time = IntToTime(e.timeStamp);
		let Dom = inList.querySelector("#k"+k);
		if(Dom != null){
			let headerbox = Dom.querySelector('.mesg-meta');
			headerbox.children[1].innerText = chat.DETAIL;
			let newTag = Dom.children[1];
			if(inList.firstChild != null){
				inList.insertBefore(Dom, inList.firstChild);
			}
			if(server != k && newTag.className != 'tag green'){
				newTag.className = 'tag green';
				++newNum;
				chatNum();
			}
		}else{
			++newNum;
			getChatHeader(k);
		}
		
		if(server == k){
			let newLi = document.createElement('li');
			newLi.setAttribute("class", mytf ? "you" : "me");
			newLi.innerHTML = '<div class="chat-thumb"><img src="resources/images/resources/chatlist2.jpg" alt=""></div><div class="notification-event"><span class="chat-message-item">'+chat.DETAIL+'</span><span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">'+time+'</time></span></div>';
			mainDom.appendChild(newLi);
			$('.chat-List > ul').scrollTop($('.chat-List > ul').prop('scrollHeight'));			
		}
	}
	
	sock.onclose = function(){
	}
	
	$('.friendz-list > li, .chat-users > li').on('click', function(event) {
			let li = event.target;
		  	while(true){
				if(li.nodeName == 'LI')break;
				li = li.parentElement;
			}  
		 	id = li.id;
			
			let name = li.querySelector("a").innerText;
		 	join(id, 0,name);
		});	 
	
	
	function IntToTime(time, type) {
		let day = null;
		let hour = null;
		let todate = new Date();
		let sentd = new Date(time);
		if(+sentd.getDate() < +todate.getDate()){
	 		if(+sentd.getDate() == +todate.getDate()-1){ // 29 30
		 		day = 'Yesterday at ';					 			
	 		}else{
	 			day = (sentd.getMonth()+1)+" / "+sentd.getDate()+" at";
	 		}
	 	}else{
	 		day = 'Today at ';					 		
	 	}
		
	 	let timetf = sentd.getHours() > 12;
	 	hour = (timetf ? (sentd.getHours()-12) : sentd.getHours()) + ":"+sentd.getMinutes()+ (timetf ? "pm" : "am");
		return day+hour;	 	
	}
	
	
	
	
</script>