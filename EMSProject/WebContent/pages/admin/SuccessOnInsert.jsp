<%@ include file = "AdminHeader.jsp" %>

<div class="w3-container">

<h3>Data Inserted SuccessFully</h3>
<hr/>
<p>
${loginDetails.loginId} <br/>
Your User Name : <br/>
${loginDetails.userName} <br/>
Your Password : <br/>
${loginDetails.password} <br/>
Your Employee Id : <br/>
${loginDetails.empId} <br/>
</p>
</div>

<%@ include file = "AdminFooter.jsp" %>