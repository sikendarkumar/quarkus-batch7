

let btn1=document.getElementById("btn1")
btn1.addEventListener('click',e=>{
	
	// XHR / fettch api
	
	fetch("/api/todos/1")
	.then(response=>response.json())
	.then(todo=>{
		console.log(todo)
	})
	
})