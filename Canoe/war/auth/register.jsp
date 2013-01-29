<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout pageTitle="Register">
<form class="form-horizontal" action="/register" method="post">
	<div class="control-group">
		<label class="control-label" for="firstname">First Name</label>
		<div class="controls">
			<input type="text" id="firstname" name="firstname" placeholder="First Name">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="lastname">Last Name</label>
		<div class="controls">
			<input type="text" id="lastname" name="lastname" placeholder="Last Name">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="birthday">Birthday (JJ/MM/YYYY)</label>
		<div class="controls">
			<input type="number" id="birthday" name="birthday" placeholder="Birthday" class="datepicker">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="mail">Email</label>
		<div class="controls">
			<input type="text" id="mail" name="mail" placeholder="Email">
		</div>
	</div>
		<div class="control-group">
		<label class="control-label" for="username">Username</label>
		<div class="controls">
			<input type="text" id="username"  name="username" placeholder="Username">
		</div>
	</div>
		<div class="control-group">
		<label class="control-label" for="pass">Password</label>
		<div class="controls">
			<input type="password" id="pass" name="pass" placeholder="Password">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="repass">Re-Password</label>
		<div class="controls">
			<input type="password" id="repass" name="repass" placeholder="Password">
		</div>
	</div>
	<div class="control-group">
		<div class="controls">		
			<a href="/" class="btn">Cancel</a>
			<button type="submit" class="btn">Register</button>
		</div>
	</div>
</form>

	<script>
		$(document).ready(function(){	
	    	$( ".datepicker" ).datepicker({ defaultDate: "-25y", changeYear: true });
	  	});
  	</script>
</z:layout>
