<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<z:layout pageTitle="Canoe - Administration - Utilisateurs">
	<h1>Users</h1>
	<div class="pull-right" style="margin-bottom: 20px;">
		<a href="/auth/register.jsp" title="Ajouter un utilisateur" class="btn btn-success">
			Ajouter un utilisateur
		</a>
	</div>
    <table class="table">
    	<tr>
    		<th>#</th>
    		<th>Nom d'utilisateur</th>
    		<th>Nom</th>
    		<th>Inscription</th>
    		<th>Dernière activité</th>
    		<th>Action</th>
    	</tr>
    	<c:forEach var="user" items="${listUsers}">
    		<tr>
    			<td></td>
    			<td>${user.username}</td>
    			<td>${user.firstname} ${user.lastname}</td>
    			<td>${user.registerDate}</td>
    			<td>${user.lastLoginDate}</td>
    			<td><a href="/admin/delete?u=${user.key}"><i class="icon-remove"></i></a></td>
    		</tr>
    	</c:forEach>
    </table>
    <div class="pull-right" style="margin-top: 20px;">
		<a href="/auth/register.jsp" title="Ajouter un utilisateur" class="btn btn-success">
			Ajouter un utilisateur
		</a>
	</div>
</z:layout>
<%-- 
<%@include file="template/header.html" %>


<%@include file="template/footer.html" %> --%>
