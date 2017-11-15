<%@ include file = "AdminHeader.jsp" %>
<div class="w3-container w3-teal">
  <h2>Search Employee Details</h2>
</div>

<div class="w3-container">
<form action="find.ems" class="w3-card-4" style="max-width:500px;margin: auto; padding:10px;" >
  <hr/>
  Search
  <hr/>
  
  <p>
  <label>   Employee ID </label>
	 <input type="text"  class="w3-input" name="empId">
  </p>
  
              
     <button class="w3-btn w3-teal">Search</button>
        
</form>   

<br/>
<br/>
<c:if test="${key != null}">
<table class="w3-table-all w3-hoverable">
<thead>
<tr class="w3-teal">
<td>Employee Id </td>
<td>First Name</td>
<td>Last Name </td>
<td>Department Name</td>
<td>Designation Name</td>
<td>Grade</td>
<td>Contact No</td>
<td>Pincode</td>
</tr>
</thead>


<tr>
	<td><c:out value="${key.empId}"><br/></c:out></td>
	<td><c:out value="${key.firstName}"><br/></c:out></td>
	<td><c:out value="${key.lastName}"><br/></c:out></td>
	<td><c:out value="${d.deptName}"><br/></c:out></td>
	<td><c:out value="${e.desigName}"><br/></c:out></td>
	<td><c:out value="${key.grade}"><br/></c:out></td>
	<td><c:out value="${key.contactNo}"><br/></c:out></td>
	<td><c:out value="${key.getPincode()}"><br/></c:out></td>
	<%-- <td><c:out value="${key.state}"><br/></c:out></td> --%>
	
</tr>
</table>
<br/><br/><br/>

</c:if>

<br/><br/>
</div>

<%@ include file = "AdminFooter.jsp" %>