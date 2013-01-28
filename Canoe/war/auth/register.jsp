<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout pageTitle="Register">
<form class="form-horizontal">
	<div class="control-group">
		<label class="control-label" for="fname">First Name</label>
		<div class="controls">
			<input type="text" id="fname" placeholder="First Name">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="lname">Last Name</label>
		<div class="controls">
			<input type="text" id="lname" placeholder="Last Name">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="age">Age</label>
		<div class="controls">
			<input type="number" id="age" placeholder="Age">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputEmail">Email</label>
		<div class="controls">
			<input type="text" id="inputEmail" placeholder="Email">
		</div>
	</div>
		<div class="control-group">
		<label class="control-label" for="login">Login</label>
		<div class="controls">
			<input type="text" id="login" placeholder="Login">
		</div>
	</div>
		<div class="control-group">
		<label class="control-label" for="pass">Password</label>
		<div class="controls">
			<input type="password" id="pass" placeholder="Password">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="repass">Re-Password</label>
		<div class="controls">
			<input type="password" id="repass" placeholder="Password">
		</div>
	</div>
	<div class="control-group">
		<div class="controls">		
			<button type="submit" class="btn">Cancel</button>
			<button type="submit" class="btn">Register</button>
		</div>
	</div>
</form>
</z:layout>
