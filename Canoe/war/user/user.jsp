<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<z:layout pageTitle="Canoë - Accueil">
	<h1>Bienvenue ${User.username}</h1>
	<hr />
	
    <table class="table table-bordered table-hover">
	    <tr>
	    	<td><strong>First Name</strong></td>
	    	<td>${User.firstname}</td>
	    </tr>    
	    <tr>
	    	<td><strong>Last Name</strong></td>
	    	<td>${User.lastname}</td>
	    </tr>    
	    <tr>
	    	<fmt:formatDate value="${User.birthday}" pattern="dd/MM/yyyy" var="fBirthday" />
	    	<td><strong>Birthday</strong></td>
	    	<td>${fBirthday}</td>
	    </tr>    
	    <tr>
	    	<td><strong>Email</strong></td>
	    	<td>${User.mail}</td>
	    </tr>    
    </table>
</z:layout>

