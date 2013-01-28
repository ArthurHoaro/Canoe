<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout pageTitle="Gestion des vols">
	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<li class="active">
			<a href="/flightAdmin/Ajout">Ajout</a>
		</li>
		<!-- Zone de recherche d'un vol -->
		<li>
			<a href="/flightAdmin/Recherche">Recherche</a>
		</li>
	</ul>
	
	<form class="form-horizontal" action="/flightAdmin/Ajout" method="post">
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
						<input required="required" type="text" id="departing" name="departing" class="datepicker" placeholder="Departing">
					</div>
					<div class="control-group">
						<input required="required" type="text" id="arrivalTime" name="arrivalTime" class="datepicker" placeholder="Arrival Time">
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
   		</TBODY>
	</table>
	<script>
	  $(function() {
	    $( ".datepicker" ).datepicker();
	  });
  	</script>
</z:layout>