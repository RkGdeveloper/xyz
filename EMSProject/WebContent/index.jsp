<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Employee Management System</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<body>



<c:if test="${msg != null }">
<div class="w3-panel w3-red">
    <h3>Invalid</h3>
    <p>${msg}..</p>
  </div>
</c:if>

<c:if test="${name != null }">
<div class="w3-panel w3-red">
    <h3>Invalid</h3>
    <p>User name is Invalid</p>
  </div>
</c:if>

<c:if test="${pass != null }">
<div class="w3-panel w3-red">
    <h3>Invalid</h3>
    <p>PassWord is incorrect</p>
  </div>
</c:if>



<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close &times;</button>
  
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-bar-item w3-button">Admin Login</button>
  
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <img src="images/capgemini-logo.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" action="validateAdminLogin.ems">
        <div class="w3-section">
          <label><b>Admin Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="usrname"  required/>
          <label><b>Password</b></label>
          <input type="hidden" name="msg"/>
          
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="psw" required/>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span>
      </div>
    </div>
  </div>
  
  
  
  
  
  <button onclick="document.getElementById('id02').style.display='block'" class="w3-bar-item w3-button">Employee Login</button>
  
  <div id="id02" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <img src="images/capgemini-logo.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" action="/action_page.php">
        <div class="w3-section">
          <label><b>Employee Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="usrname" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="psw" required>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span>
      </div>



    </div>
  </div>
  
  
</div>

<div id="main">

<div class="w3-teal">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
  <div class="w3-container">
    <h1>${appTitle}</h1>
  </div>
</div>

<img src="images/cappp.jpg" style="width:100%;">

<div class="w3-container">



<p>This project is aimed at developing Online Employee Maintenance System.  
This is an integrated system that contains both the user (Employee) component and the Admin component</p>
<p>This is an Intranet based application that can be accessed throughout the organization and this is a web based application that can be accessed over the web. 
</p>
<p>This system can be used to search for Employees based on search condition, add individual employee, modify an existing employee details and display all employee details across locations within an organization.</p>
</div>

</div>

<script>
function w3_open() {
  document.getElementById("main").style.marginLeft = "25%";
  document.getElementById("mySidebar").style.width = "25%";
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("openNav").style.display = 'none';
}
function w3_close() {
  document.getElementById("main").style.marginLeft = "0%";
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("openNav").style.display = "inline-block";
}
</script>

<div class="w3-container w3-teal">
  <h5>Capgemini</h5>
  <p>  © 2017 Copyright Capgemini </p>
</div>


</body>
</html>
