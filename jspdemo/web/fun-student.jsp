<%@page import="com.techno.jsp.FunUtils, java.util.*"%>
<%@ page import="com.techno.jsp.Student" %>
<%@ page import="com.techno.jsp.FunStudent" %>
<html>

<body>

<p>Lets Have Some Fun <%= FunUtils.makeItLower("WELCOME TO JAVA")%></p>

<%
    List<Student> arrayList = new ArrayList<Student>();

    Student student = new Student("Ahmad","Hassan","Lahore");
    arrayList.add(student);
    arrayList.add(new Student("Kashif","Ali","Lahore"));
    Student student1 = new Student();
    arrayList.add(student1);
    Student student2 = new Student();
    arrayList.add(student2);
    student2.setFirstName("Zahid");
    student2.setLastName("Khan");
    student2.setAddress("Lahore");

    for (Student s:arrayList){
        out.println("<B>"+s+"</B></BR>");
    }


%>

<p>Lower Case : Lets Have Some Fun through Loop <%
    for (int i = 0; i <arrayList.size() ; i++) {
        out.println("<B>"+FunStudent.makeItLower(arrayList.get(i))+"</B></BR>");
    }
%> </p>
    </BR>
    </BR>
    </BR>
    <p>Upper Case : Lets Have Some Fun through Loop <%
    for (int i = 0; i <arrayList.size() ; i++) {
        out.println("<B>"+FunStudent.makeItUpper(arrayList.get(i))+"</B></BR>");
    }
%> </p>
</body>

</html>
