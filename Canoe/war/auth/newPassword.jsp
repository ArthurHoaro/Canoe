<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<z:layout pageTitle="Login">
	<h1>First Login</h1>
	<hr />

	<c:if test="${error != null}">
		<div class="alert alert-error">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${error}
		</div>
	</c:if>

	<form class="form-horizontal" action="/auth/newpassword" method="post">
		<div class="control-group">
			<label class="control-label" for="pass">New Password</label>
			<div class="controls">
				<input type="password" id="pass" name="pass"
					placeholder="New Password">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="repass">Re-New Password</label>
			<div class="controls">
				<input type="password" id="repass" name="repass"
					placeholder="Re-New Password">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<a href="/auth/login.jsp" class="btn">Cancel</a>
				<button type="submit" class="btn">Save</button>
			</div>
		</div>
	</form>

</z:layout>
