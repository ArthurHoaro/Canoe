<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<z:layout pageTitle="Gestion des vols">
	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<li class="active">
			<a href="/admin/flight-add">Ajout</a>
		</li>
		<!-- Zone de recherche d'un vol -->
		<li>
			<a href="/flight/flight-search">Recherche</a>
		</li>
		<li>
			<a href="/flight/history">Historique</a>
		</li>
	</ul>
	
	<form class="form-horizontal" action="/admin/flight-add" method="post">
			<div class="row-fluid">
				<div class="span3">
					<div class="control-group">	
			      		<input required="required" type="text" id="leavingFrom" name="leavingFrom" placeholder="Leaving From">
			      	</div>
			      	<div class="control-group">
			      		<input required="required" type="text" id="goingTo" name="goingTo" placeholder="Going To">
			      	</div>
				</div>
				<div class="span3">
					<div class="control-group">
						<input required="required" type="text" id="departing" name="departing" class="datetimepicker" placeholder="Departing">
					</div>
					<div class="control-group">
						<input required="required" type="text" id="arrivalTime" name="arrivalTime" class="datetimepicker" placeholder="Arrival Time">
					</div>
				</div>
				<div class="span3">
					<div class="control-group">
						<input required="required" type="text" id="price" name="price" placeholder="Price">
					</div>
					<div class="control-group">
						<input required="required" type="text" id="availableSeats" name="availableSeats" placeholder="Available seats">
					</div>
				</div>
				<div class="span3">
					<div class="control-group">
						<input type="submit" id="add" value="Add">
					</div>
				</div>
			</div>
		</form>		
	
	<span class="divider"></span>
	
	<table class="table table-striped table-bordered">
		<THEAD>
	       <tr>
	           <th>Date</th>
	           <th>Departure Town</th>
	           <th>Arrival Town</th>
	           <th>Flight duration</th>
	           <th>Available seats</th>
	           <th>Price</th>
	           <th></th>
	       </tr>
   		</THEAD>
   		<TBODY>
   			<c:forEach items="${requestScope['flightList']}" var="flight" varStatus="status">
   				<TR>
					<TD>
						<fmt:formatDate value="${flight.dateDepart}" pattern="dd/MM/yyyy" var="dateDepartFlight" />
						${ dateDepartFlight }
					</TD>
					<TD>
						${flight.from}
					</TD>
					<TD>
						${flight.to}
					</TD>
					<TD>
						<fmt:formatDate value="${flight.duration}" pattern="dd' jours et' HH'h'mm" var="duration" />
						${ duration }
					</TD>
					<TD>
						${ flight.availableSeats }
					</TD>
					<TD>
						${ flight.price }
					</TD>
					<TD>
						<input type="submit">
							<i class="icon-remove"></i>
						</input>
					</TD>
				</TR>
   			</c:forEach>
   		</TBODY>
	</table>
	<script>
		$(document).ready(function(){	
	    	$( ".datetimepicker" ).datetimepicker();
	    	$( ".timepicker" ).timepicker();
	  	});
  	</script>
</z:layout>