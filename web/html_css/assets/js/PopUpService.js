class PopUpService{
	#callbak;
	
	open(url="", param={}, callback, width=702, height=635){
		this.#callbak = callback
		
		const [left, top] = this.getLeftTop(width, height);
		window.open("" ,"popUP", `width=${width}, height=${height}, left=${left}, top=${top}, toolbar=no, resizable=no scrollbars=no`);
		
		const form = this.createForm(url, param, "post");
		form.submit();
		form.remove();
	};
	
	getLeftTop(width, height){
		const curX = window.screenLeft;
		const curY = window.screenTop;
		
		const curWidth = document.body.clientWidth;
		const curHeight = document.body.clientHeight;
		
		if(curY < 0) curY = 0;
		  
		const nLeft = curX + (curWidth / 2) - (width / 2);
		const nTop = curY + (curHeight / 2) - (height / 2);
		
		return [nLeft, nTop];
	}
	
	createForm(url, param={}, method="get"){
		const form = document.createElement("form");
		form.setAttribute("action", url);
		form.setAttribute("method", method);
		form.setAttribute("target", "popUP");
		
		Object.keys(param).forEach(key => {
			const value = param[key];
			
			const input = document.createElement("input");
			input.setAttribute("type", "hidden");
			input.setAttribute("name", key);
			input.setAttribute("value", value);
			
			form.append(input);
		});
		 
		document.getElementsByTagName("body")[0].appendChild(form);
		
		return form;
	};
	
	popUpCallback (res){
		const data = JSON.parse(decodeURIComponent(res));
		this.#callbak(data);
	}
}

export {PopUpService};