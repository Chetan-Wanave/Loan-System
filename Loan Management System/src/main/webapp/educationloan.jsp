<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ include file="home.jsp" %>


<div style="margin-left: 25%;margin-right: 25%;">
		<h3 class="text-success" style="text-align:center;">Enter Student Loan Information</h3>
        <form action="LoanController" method="get">
        	<div class="mb-2">
                <label for="loanAmount" class="form-label">Loan Amount</label>
                <input type="number" class="form-control" name="loanAmount" aria-describedby="loanHelp" required>
            </div>
            <div class="mb-2"> 
                <label for="adhaar" class="form-label">ADHAAR Number</label>
                <input type="number" class="form-control" name="adhaar" aria-describedby="adhaarHelp" required>
            </div>
            <div class="mb-2">
                <label for="pan" class="form-label">PAN Card Number</label>
                <input type="number" class="form-control" name="pan" required>
            </div>
            <h4 class="text-success text-center" style="text-align:center;">Account Details</h4>
            <div class="mb-2">
                <label for="accountno" class="form-label">Bank Account Number </label>
                <input type="text" class="form-control" name="accountno" required>
            </div>
             <div class="mb-2">
                <label for="ifsc" class="form-label">Bank IFSC Code </label>
                <input type="text" class="form-control" name="ifsc" required>
            </div>
             <div class="mb-2">
                <label for="document" class="form-label">Student Document Proof </label>
                <input type="file" class="form-control" name="document" required>
            </div>
            <button type="submit" class="btn btn-primary">Apply</button>
            <br>
        </form>
</div>