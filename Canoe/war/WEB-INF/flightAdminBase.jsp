<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout pageTitle="Gestion des vols">
	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<li>
			<a href="/flightAdmin/Ajout">Ajout</a>
			<div>
				<%@ include file="flightAjout.jsp" %>
			</div>
		</li>
		<!-- Zone de recherche d'un vol -->
		<li>
			<a href="/flightAdmin/Recherche">Recherche</a>
			<div>
				<%@ include file="flightRecherche.jsp" %>
			</div>
		</li>
	</ul>		
	
	<span class="divider"></span>
	
	<div class="row-fluid">
		<div class="span10 offset1">
			<table class="table table-striped table-bordered">
				<THEAD>
			       <tr>
			           <th>Date</th>
			           <th>Departure Time</th>
			           <th>Arrival Time</th>
			           <th>Flight duration</th>
			           <th>Available seats</th>
			           <th>Price</th>
			           <th></th>
			       </tr>
		   		</THEAD>
		   		<TBODY>
		   		</TBODY>
			</table>
		</div>
	</div>
</z:layout>
