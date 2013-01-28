<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout pageTitle="Canoe - Administration - Utilisateurs">
	<h1>Users</h1>
    <table class="table">
<<<<<<< HEAD
    
=======
    	<tr>
    		<th>#</th>
    		<th>Nom</th>
    		<th>Inscription</th>
    		<th>Dernière activité</th>
    	</tr>
    	<c:forEach var="user" items="${listUsers}">
    		<tr>
    			<td></td>
    			<td>${user.name}</td>
    			<td></td>
    			<td></td>
    		</tr>
    	</c:forEach>
>>>>>>> c1b87aa94ce81ea35946520d32b2a7db06ba6965
    </table>
</z:layout>

