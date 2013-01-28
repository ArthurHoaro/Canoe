<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout pageTitle="Canoe - Administration - Utilisateurs">
	<h1>Users</h1>
    <table class="table">
    	<tr>
    		<th>#</th>
    		<th>Nom d'utilisateur</th>
    		<th>Nom</th>
    		<th>Inscription</th>
    		<th>Dernière activité</th>
    	</tr>
    	<c:forEach var="user" items="${listUsers}">
    		<tr>
    			<td></td>
    			<td>${user.username}</td>
    			<td>${user.fistname} ${user.lastname}</td>
    			<td>${user.registerDate}</td>
    			<td>${user.lastLoginDate}</td>
    		</tr>
    	</c:forEach>
    </table>
</z:layout>
<%-- 
<%@include file="template/header.html" %>


<%@include file="template/footer.html" %> --%>
