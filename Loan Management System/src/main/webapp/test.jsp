<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="UserData.userModel" %>


<% 

	if(!session.isNew()){
		
		ResultSet userSet = (ResultSet) session.getAttribute("userset");
		try {
			if( userSet != null ){
				%>
				<div class="container">
  					<div class="row justify-content-center">
    					<div class="col-md-8">
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