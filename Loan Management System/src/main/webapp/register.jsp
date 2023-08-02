<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>

<!-- Registration Form -->
    <div style="margin-left: 25%;margin-right: 25%;">
        <form action="RegisterController" method="get">
        	<div class="mb-2">
                <label for="username" class="form-label">User Name</label>
                <input type="text" class="form-control" name="username" aria-describedby="userHelp" required>
            </div>
            <div class="mb-2"> 
                <label for="email" class="form-label">Email address</label>
                <input type="text" class="form-control" name="email" aria-describedby="emailHelp" required>
            </div>
            <div class="mb-2">
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" name="password" required>
            </div>
            <div class="mb-2">
                <label for="confirm_password" class="form-label">Confirm Password</label>
                <input type="text" class="form-control" name="confirm_password" required>
            </div>
            <div class="mb-2 form-check">
                <input type="checkbox" class="form-check-input" name="check">
                
                <label class="form-check-label" for="check">Remember me</label>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
            <br>
        </form>
       
        <% if(!session.isNew()){
        	String error = (String) session.getAttribute("error");
        	if(error!=null){
        		%>
        		<p class="text-danger" style="background-color: aquamarine;border-radius: 6px;padding: 13px;"><%  out.println(error); %> </p>
        		<%
        	}		  
        	
        }
		%>     
    </div>

