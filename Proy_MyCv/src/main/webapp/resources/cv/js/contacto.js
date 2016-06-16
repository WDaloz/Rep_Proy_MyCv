window.onload=function()
{
	reload();
}

function saludo(data)
{

	alert(data.valor)
	document.getElementById("frmContacto:txtName").value = "";
	document.getElementById("frmContacto:txtEmail").value = "";
	document.getElementById("frmContacto:txtMessage").value = "";
	
	
}

function reload()
{

	var publicKey = "6LfvORoTAAAAAMUz4noAbqG-L-V7nnWDD-kIwwDJ";
	var div = "divRecap";
	Recaptcha.create(publicKey,div,{theme: "white"});
	
	return false;

}