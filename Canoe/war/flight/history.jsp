<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<z:layout pageTitle="Gestion des vols">
	<h1>Historique de recherche</h1>
	<hr />

	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">		
		<c:if test="${User.admin}">
			<li>
				<a href="/admin/flight-add">Ajout</a>
			</li>
		</c:if>
		<!-- Zone de recherche d'un vol -->
		<li>
			<a href="/flight/flight-search">Recherche</a>
		</li>
		<li class="active">
			<a href="/flight/history">Historique</a>
		</li>
	</ul>
	
	<span class="divider"></span>
	
	<table class="table table-striped table-hover">
		<thead>
	       <tr>
       			<th>Date</th>
	           <th>Départ de</th>
	           <th>Arrivée à</th>
	           <th>Le</th>
	           <th># de résultats</th>
	           <th>Prix moyen</th>
	       </tr>
   		</thead>
   		<tbody>
   			<c:forEach var="histoEntry" items="${history}">
   				<tr>
   					<fmt:formatDate value="${histoEntry.date}" pattern="dd/MM/yyyy à HH:mm" var="fDate" />
   					<td>${fDate}</td>
   					<td>${histoEntry.from}</td>
   					<td>${histoEntry.to}</td>
   					<fmt:formatDate value="${histoEntry.departure}" pattern="dd/MM/yyyy" var="fDeparture" />
   					<td>${fDeparture}</td>
   					<td>${histoEntry.nbResponse}</td>
   					<td>${histoEntry.avgPrice}</td>
   				</tr>
   			</c:forEach>
   		</tbody>
	</table>
</z:layout>