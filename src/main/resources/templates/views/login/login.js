<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
var app = new Vue({
    el: "#app",
	data: {
		message: "하이룽~~~",
		username:"",
		password:"",
	},
	method:{
		login :function(){
			alert("로그인 누름 ");
			axios.post('/api/login', {})
			  .then(res => {
			    console.log(res.data)
			  });
		}
	}
});