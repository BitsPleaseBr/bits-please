 cookies = {
	"indexes": [],
	"valores": [],
	"put": function (key, value) {
		
		var index = this.indexes.indexOf(key);
		
		if (index == -1) {
			
			this.indexes.push(key);
			this.valores.push(value);
		} else {
			
			this.valores[index] = value;
		}
	},
	"get": function (key) {
		
		var index = this.indexes.indexOf(key);
		
		if (index == -1)
			return null;
		
		return this.valores[index];
	},
	"remove": function (key) {
		
		var index = this.indexes.indexOf(key);
		
		if (index != -1) {
			
			this.indexes.splice(index);
			this.valores.splice(index);
		}
	},
	"load": function () {
		
		var cookies = document.cookie.split(";");
		
		this.indexes.length = 0;
		this.valores.length = 0;
		
		for (var i = 0; i < cookies.length; i++) {
		
			var key = cookies[i].split("=")[0];
			var value = cookies[i].split("=")[1];
		
			this.indexes.push(key);
			this.valores.push(value);
		}
	},
	"save": function () {
		
		var cookies = "";
		
		if (this.indexes.indexOf('expires') == -1) {
			
			var now = new Date();
			now.setTime(now.getTime() + 24 * 60 * 60 * 1000);
			
			this.put('expires', now.toGMTString());	
		}
		
		for (var i = 0; i < this.indexes.length; i++) {
			
			cookies += this.indexes[i] + "=" + this.get(this.indexes[i]) + ";";
		}
		
		document.cookie = cookies;
	}
}