<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="home.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="UserData.userModel" %>


<% if(!session.isNew()){
		userModel r = (userModel) session.getAttribute("data");
		if(r!= null){
			%>
			<h1 style="text-align:center;"> Hey <% out.println(r.getUsername()); %> </h1>
			<p class="text-success" id="message" style="text-align:center;background-color:aquamarine;border-radius: 6px;padding: 13px;margin-left: 25%;margin-right: 25%;margin-top:2%;">  You have been logged in... </p>
			<%
		}	
	}	
%>
	
<%
	if(!session.isNew()){
		String approval = (String) session.getAttribute("approval");
		if(approval != null){
			%>
			<!-- <h1 style="text-align:center;"> Hey  </h1> --> 
			<p class="text-darkbackground-color:aquamarine;" id="message" style="text-align:center;background-color:aquamarine;border-radius: 6px;padding: 13px;margin-left: 25%;margin-right: 25%;margin-top:2%;">  Hey <% out.println(approval); %> </p>
			
			<form action="LoanRetriver" method="get">
				<div class="container">
				  <div class="row justify-content-center">
				    <div class="col-md-6 mt-4 text-center">
				      <input type="submit" class="btn btn-info btn-sm mb-1" value="Show Loan">
				    </div>
				  </div>
				</div>
			</form>
			
			<%
			
		}
	}
%>

<% 

	if(!session.isNew()){
		
		ResultSet userSet = (ResultSet) session.getAttribute("userset");
		try {
			if( userSet != null ){
				%>
				<div class="container">
  					<div class="row justify-content-center">
    					<div class="col-md-8 mt-4">
							<table class="table table-striped table-bordered table-hover table-bordered rounded">
							  <tr class="thead-dark">
							    <th>Sr. No.</th>
							    <th>Amount</th>
							    <th>Account Number</th>
							    <th>No. of Years</th>
							    <th>Interest</th>
							    <th>User Email</th>
							  </tr>
				<%
				int i = 0;
				while(userSet.next()) {
					%>
					  <tr>
					  	<td> <% out.println(++i); %> </td>
					    <td> <% out.println(userSet.getDouble(2)); %> </td>
					    <td> <% out.println(userSet.getLong(3)); %> </td>
					    
					    <td> <% out.println(userSet.getInt(4)); %> </td>
					    <td> <% out.println( userSet.getInt(4) * 10* userSet.getDouble(2)/100); %> </td>
					    <td> <% out.println(userSet.getString(5)); %> </td>
					  </tr>

					
					<%
				}
				
				%>
						</table>
					</div>
 				</div>
			</div>
				<%
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
%>



	
	