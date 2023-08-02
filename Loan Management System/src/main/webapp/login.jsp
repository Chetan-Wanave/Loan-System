<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>

<!-- Login Form -->
    <div style="margin-left: 25%;margin-right: 25%;margin-top:2%;">
    	<%-- Session 1 --%>
    	<% if(!session.isNew())
        {
    		int i = 0;
    		try {
    			i = (Integer) session.getAttribute("data");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	if(i>0){
        		%>
        		<p class="text-success" id="message" style="text-align:center;background-color: aquamarine;border-radius: 6px;padding: 13px;">  Registered Successfully. Login here </p>
        		<%
        	}
        }
        %> 
        <form action="LoginController" method="get">
            <div class="mb-2">
                <label for="username" class="form-label">User Name</label>
                <input type="text" class="form-control" id="username" name="username" aria-describedby="userHelp" required>
            </div>
            <div class="mb-2">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="password" required>
            </div>
            <div class="mb-2 form-check">
                <input type="checkbox" class="form-check-input" id="check">
                <label class="form-check-label" for="check">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <br><br>
        </form>
      	
      	<% if(!session.isNew())
        {
    		String s = (String) session.getAttribute("error");
    			if(s!=null){
    				
        		%>
        		<p class="text-danger" id="message" style="text-align:center;background-color: aquamarine;border-radius: 6px;padding: 13px;"> <% out.println(s); %> </p>
        		<%
        	}
        }
        %> 
        
    </div>
     