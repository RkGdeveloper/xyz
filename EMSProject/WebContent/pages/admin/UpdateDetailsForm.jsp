<%@ include file = "AdminHeader.jsp" %>

<br/>
<hr/>
<br/>


<div class="w3-container w3-teal">
  <h2>Update Employee Details</h2>
</div>

<sf:form class="w3-card-4"  action="doUpdation.ems" style="max-width:500px;margin: auto; padding:10px;" commandName="empBean" modelAttribute="empBean" method="POST">

<p>
  <label>Employee ID:</label>
  <sf:input class="w3-input" type="text" path="empId" readonly="true"/></p>
  <p style="color:red">
  <sf:errors class="w3-input" type="text" path="empId" /></p>
  
  <p>
  <label>First Name</label>
  <sf:input class="w3-input" type="text" path="firstName" /></p>
  <p style="color:red">
  <sf:errors class="w3-input" type="text" path="firstName" /></p>
  
  <p>
  <label>Last Name</label>
  <sf:input class="w3-input" type="text" path="lastName" /></p>
  <p style="color:red">
  <sf:errors class="w3-input" type="text" path="lastName" /></p>
  
  <p>
  <label>Date Of Join</label>
  <sf:input  class="w3-input" type="date" path="dateOfJoining" /></p>
  <!-- <p style="color:red"> -->
  <%-- <sf:errors class="w3-input" type="date" path="dateOfJoining" /></p> --%>
  
  <p>
  <label>Date Of Birth</label>
  <sf:input class="w3-input" type="date" path="dateOfBirth" /></p>
  <%-- <p style="color:red">
  <sf:errors class="w3-input" type="date" path="dateOfBirth" /></p>
   --%>
  <p>
  	Select Department
  	<sf:select path="deptId" class="w3-select w3-border">
			
		    <sf:options items="${deptSet}"/>
	
	</sf:select> 

  </p>
  
  
  <p>
  	Select Designation
  	<sf:select path="designationId" class="w3-select w3-border">
			
		    <sf:options items="${designSet}"/>
	
	</sf:select> 
	
  </p>
  
  <p>
  <label>Gender</label>  
  <p>
  <input class="w3-radio" type="radio" name="gender" value="male" checked>
  <label>Male</label></p>
  <p>
  <input class="w3-radio" type="radio" name="gender" value="female">
  <label>Female</label></p>
  
  <p>
  <label>Salary</label>
  <sf:input class="w3-input" type="text" path = "salary" /></p>
  <p style="color:red">
   <sf:errors class="w3-input" type="text" path="salary" /></p>
  
  
   <p>
  		Select Marital Status
  	<sf:select path="martialStatus" class="w3-select w3-border">
			
		    <sf:options items="${maritalSet}"/>
	
	</sf:select> 

  </p>
  
  <p>
  <label>Contact Number</label>
  <sf:input class="w3-input" type="text" path="contactNo" /></p>
  <p style="color:red">
  <sf:errors class="w3-input" type="text" path="contactNo" /></p>
	  
  <p>
  <label>Address Line1</label>
  <sf:input class="w3-input" type="text" path="addressline1" /></p>
   <p style="color:red">
  <sf:errors class="w3-input" type="text" path="addressline1" /></p>

  <p>
  <label>Address Line2</label>
  <sf:input class="w3-input" type="text" path="addressline2" /></p>
   <p style="color:red">
  <sf:errors class="w3-input" type="text" path="addressline2" /></p>

  <p>
  <label>City</label>
  <sf:input class="w3-input" type="text" path="city" /></p>
   <p style="color:red">
  <sf:errors class="w3-input" type="text" path="city" /></p>

  <p>
  <label>PinCode</label>
  <sf:input class="w3-input" type="text" path="pincode" /></p>
   <p style="color:red">
  <sf:errors class="w3-input" type="text" path="pincode" /></p>

  <p>
  <label>State</label>
  <sf:input class="w3-input" type="text" path="state" /></p>
   <p style="color:red">
  <sf:errors class="w3-input" type="text" path="state" /></p>

  
<button class="w3-btn w3-teal">Update Details</button>

</sf:form>


<br/>
<hr/>
<br/>

<%@ include file = "AdminFooter.jsp" %>





