<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<z:layout pageTitle="Login">
	<form class="form-horizontal" action="/login" method="post">
		<div class="control-group">
			<label class="control-label" for="username">Login</label>
			<div class="controls">
				<input type="text" id="username" name="username" placeholder="Email">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="pass">Password</label>
			<div class="controls">
				<input type="password" id="pass" name="pass" placeholder="Password">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox"> <input type="checkbox">
						Remember me </label> 				
				<button type="submit" class="btn">Sign in</button>
			</div>
		</div>		
	</form>
<p class="alert alert-error">${error}</p>
</z:layout>
