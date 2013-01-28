<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout pageTitle="Gestion des vols">
	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<li>
			<a href="/flightAdmin/Ajout">Ajout</a>
		</li>
		<!-- Zone de recherche d'un vol -->
		<li>
			<a href="/flightAdmin/Recherche">Recherche</a>
		</li>
	</ul>
	
	<form class="form-horizontal">
			<div class="row-fluid">
				<div class="span3">
				  <div class="control-group">
				    <label class="control-label" for="leavingFrom">Leaving From</label>
				    <div class="controls">
				      <input type="text" id="leavingFrom" placeholder="Leaving From">
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="goingTo">Going To</label>
				    <div class="controls">
				      <input type="text" id="goingTo" placeholder="Going To">
				    </div>
				  </div>
				</div>
				<div class="span3">
					<div class="control-group">
					    <label class="control-label" for="departing">Departing</label>
					    <div class="controls">
					      <input type="text" id="departing" placeholder="Departing">
					    </div>
				  	</div>
					 <div class="control-group">
					   <label class="control-label" for="arrivalTime">Arrival Time</label>
					   <div class="controls">
					     <input type="text" id="arrivalTime" placeholder="Arrival Time">
					   </div>
					 </div>
				</div>
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="price">Price</label>
						<div class="controls">
						  <input type="text" id="price" placeholder="Price">
						</div>
	 				</div>
					<div class="control-group">
						<label class="control-label" for="availableSeats">Available seats</label>
						<div class="controls">
						  <input type="text" id="availableSeats" placeholder="Available seats">
						</div>
					</div>
				</div>
				<div class="span3">
					<div class="control-group">
						<div class="controls">
							<input type="submit" id="add" value="Add">
						</div>
					</div>
				</div>
			</div>
		</form>		
	
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