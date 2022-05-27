<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Login lobj=new Login();
		lobj.setUname(request.getParameter("uname"));
		lobj.setPass(request.getParameter("pass"));
		AccountDao ad=new AccountDao();
		
		boolean b=ad.LoginData(lobj);
		if(b)
		{
			response.sendRedirect("Dashboard.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
	
	
</body>
</html>