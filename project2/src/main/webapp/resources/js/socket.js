let sock = new SockJS(contextPath+"/echo");


let id = null;
		let member = null;
		let myno = null;
		let first = false;
		
		let mainDom = document.querySelector('.chat-List > ul')
		
		
		function sendMessage() {
		    sock.send($("#send-box").val());
		    $('#send-box').val('')
		}
		
		function on() {
			if(first){
				$.ajax({
					url:contextPath+"/createRoom",
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

		
		
		
		sock.onmessage = function(e){
			let chat = JSON.parse(e.data);
			let mytf = chat.CHAT_OTHER_NO == myno;
			
			
			
			let newLi = document.createElement('li');
			newLi.setAttribute("class", mytf ? "you" : "me");
			newLi.innerHTML = '<div class="chat-thumb"><img src="resources/images/resources/chatlist2.jpg" alt=""></div><div class="notification-event"><span class="chat-message-item">'+chat.DETAIL+'</span><span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">Yesterday at 8:10pm</time></span></div>';
			mainDom.appendChild(newLi);
			$('.chat-List > ul').scrollTop($('.chat-List > ul').prop('scrollHeight'));
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
			
		 	 $.ajax({
		 		url:contextPath+"/jointwo",
		 		type:"POST",
		 		data:{id:id},
		 		success: function sc(s) {
					if(s == '')first = true;
					let name = li.querySelector("a").innerText;
					mainDom.innerHTML = '';
					if(!first){
						member = s.member;
						let chat = s.chat;
						myno = s.my_other_no;
						
						chat.forEach(c => {
							let mytf = c.CHAT_OTHER_NO == myno;
							
							let newLi = document.createElement('li');
							newLi.setAttribute("class", mytf ? "you" : "me");
							newLi.innerHTML = '<div class="chat-thumb"><img src="resources/images/resources/chatlist2.jpg" alt=""></div><div class="notification-event"><span class="chat-message-item">'+c.DETAIL+'</span><span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">Yesterday at 8:10pm</time></span></div>';
							mainDom.appendChild(newLi);
						})
						$('.chat-List > ul').scrollTop($('.chat-List > ul').prop('scrollHeight'));
					} 
					
					let chatBox = document.querySelector('.chat-box');
					chatBox.querySelector('h6').innerText = name;
					$('.chat-box').addClass("show");
				}
		 	}) 
		});	 