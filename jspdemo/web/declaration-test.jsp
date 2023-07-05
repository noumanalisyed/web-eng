<html>

<body>


<%!
	String makeItLower(String data) {
		return data.toLowerCase();
	}

	float tempToFarenheit(float celcius){
		return (celcius * 9/5) + 32;
	}
%>

Lower case "Hello World": <%= makeItLower("Hello World") %>

<%
	float Mid1[] = {10,25,23,17,18};
	float Mid2[] = {23,10,12,14,18};
	float finalExam[] = {22,34,45,37,29};



	if(tempToFarenheit(100) > 100){
		out.println(" Hot ");
	}
	else{
		out.println(" Normal ");
	}
%>
Celcius = 100 equivalent to Farenheit = <%= tempToFarenheit(100)%>

</body>
</html>
