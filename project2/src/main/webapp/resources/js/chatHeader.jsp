<script type="text/javascript">
	//dropdowns
	const headerChat = setting.children[2];
	const headerNum = headerChat.children[0].children[1];
	const ChatInDiv = headerChat.children[1];
	const inSpan = ChatInDiv.children[0]; 
	const inList = ChatInDiv.children[1];

	let infont = null;
	let inA = null;
	let newFont = null;
	let newNum = 0;
	
	function chatEvent(e) {
		let li = e.target;
	  	while(true){
			if(li.nodeName == 'LI')break;
			li = li.parentElement;
		}
	  	let id = li.id.substr(1);
	  	let name = li.querySelector('h6').innerText;
	  	join(id,1,name);
	  	
 	}
	
	function getChatHeader(k) {
		$.ajax({
			url:"${pageContext.request.contextPath}/headerChat",
			data:{k: k},
			type:"POST",
			success: function sc(s) {
				let list = s.list == null ? null : s.list;
				newNum = s.newnum == null ? newNum : s.newnum;
				chatNum(newNum);
				if(list != null){	
					if(k == null){						
						list.forEach(list => {
							let newtf = list.STAT == 0 && list.USR_ID != "${t == 'm' ? login.member_id : t == 'c' ? login.createo_mng_id : login.bmember_id}";
							let newLi = document.createElement('li');
							newLi.setAttribute("id","k"+list.CHAT_ROOM_NO);
							newLi.innerHTML = '<a href="notifications.html" title=""><img src="${finalPath}resources/images/resources/thumb-1.jpg" alt=""><div class="mesg-meta"><h6>'+list.TITLE+'</h6><span>'+list.DETAIL+'</span><i>$2 min ago$</i></div></a><span class="'+(newtf ? "tag green" : "tag")+'">New</span>';	
							inList.appendChild(newLi);							
						})
						$('.drops-menu > li').on("click",function (event) {chatEvent(event)})
					}else{
						let newtf = list[0].STAT == 0 && list[0].USR_ID != "${t == 'm' ? login.member_id : t == 'c' ? login.createo_mng_id : login.bmember_id}";
						let newLi = document.createElement('li');
						newLi.setAttribute("id","k"+list[0].CHAT_ROOM_NO);
						newLi.innerHTML = '<a href="notifications.html" title=""><img src="${finalPath}resources/images/resources/thumb-1.jpg" alt=""><div class="mesg-meta"><h6>'+list[0].TITLE+'</h6><span>'+list[0].DETAIL+'</span><i>$2 min ago$</i></div></a><span class="'+(newtf ? "tag green" : "tag")+'">New</span>';							
						if(inList.firstChild != null){
							inList.insertBefore(newLi, inList.firstChild);								
						}else{
							inList.appendChild(newLi);															
						} 
						newLi.onclick = function (event) {chatEvent(event)};
					}
				}
			}
		}) 	
	}
	
 	
	
	function chatNum() {
		headerNum.innerText = newNum;
		if(newNum != 0){
			newFont = document.createElement('font');
			newFont.innerHTML = '<a>'+newNum+'</a> New Messages';
			inFont = newFont;
			inA = newFont.firstChild;
			inSpan.appendChild(newFont);
		}else if(newFont != null){
			inSpan.innerHTML = '';
			
		}
	}
	
	function headerTime() {
		
	}
	
	getChatHeader(null);
	
</script>