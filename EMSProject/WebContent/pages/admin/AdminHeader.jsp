<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- <link rel="stylesheet" href="css/w3.css">
 -->
 </head>

<body>
<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="leftMenu">
  <button onclick="closeLeftMenu()" class="w3-bar-item w3-button w3-large">Close &times;</button>
  <a href="prepareAddEmplForm.ems" class="w3-bar-item w3-button">Add New Employee</a>
  <a href="searchEmployee.ems" class="w3-bar-item w3-button">Search Employee</a>
  <a href="updateEmployee.ems" class="w3-bar-item w3-button">Update Employee Details</a>
   <a href="getAllEmployees.ems" class="w3-bar-item w3-button">View All Employee Details</a>
  
  
</div>

<div class="w3-sidebar w3-bar-block w3-card w3-animate-right" style="display:none;right:0;" id="rightMenu">
  <button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-large">Close &times;</button>
  <a href="logoutAdmin.ems" class="w3-bar-item w3-button">Logout</a>
  <a href="#" class="w3-bar-item w3-button">About Admin</a>
  <a href="#" class="w3-bar-item w3-button">Setting</a>
</div>

<div class="w3-teal">
  <button class="w3-button w3-teal w3-xlarge w3-left" onclick="openLeftMenu()">&#9776;</button>
  <button class="w3-button w3-teal w3-xlarge w3-right" onclick="openRightMenu()">&#9776;</button>
  <div class="w3-container">
    <h1>Welcome Admin To DashBoard</h1>
  </div>
</div>
