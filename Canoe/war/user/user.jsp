<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout pageTitle="Accueil">
    <table class="table table-bordered table-hover">
	    <tr>
	    	<td>First Name </td><td>${User.firstname}</td>
	    </tr>    
	    <tr>
	    	<td>Last Name </td><td>${User.lastname}</td>
	    </tr>    
	    <tr>
	    	<td>Birthday</td><td>${User.birthday}</td>
	    </tr>    
	    <tr>
	    	<td>Email</td><td>${User.mail}</td>
	    </tr>    
    </table>
</z:layout>

