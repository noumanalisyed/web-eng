<%@page import="com.techno.jsp.FunUtils, java.util.*"%>
<html>

<body>

<p>Lets Have Some Fun <%= FunUtils.makeItLower("WELCOME TO JAVA")%></p>

<%
    List<String> arrayList = new ArrayList<String>();

    arrayList.add("HELLO");
    arrayList.add("WELCOME");
    arrayList.add("TO");
    arrayList.add("JAVA");
    arrayList.add("WELCOME TO PAKISTAN");

%>

<p>Lets Have Some Fun through Loop <%
    for (int i = 0; i <arrayList.size() ; i++) {
        out.println(FunUtils.makeItLower(arrayList.get(i)+" , "));
    }
%> </p>
</body>

</html>
