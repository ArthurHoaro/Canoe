<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  version="2.0">
<z:layout pageTitle="Canoe - Administration - Utilisateurs">
	<h1>Users</h1>
    <table class="table">
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
    </table>
</z:layout>
<%-- 
<%@include file="template/header.html" %>


<%@include file="template/footer.html" %> --%>
