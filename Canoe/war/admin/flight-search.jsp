<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout pageTitle="Gestion des vols">
	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<li>
			<a href="/admin/flight-add">Ajout</a>
		</li>
		<!-- Zone de recherche d'un vol -->
		<li class="active">
			<a href="/admin/flight-search">Recherche</a>
		</li>
	</ul>
	
	<form class="form-horizontal" action="/admin/flight-search" method="post">
		<div class="row-fluid">
			<div class="span3">
			  <div class="control-group">
			      <input type="text" id="leavingFrom" name="leavingFrom" placeholder="Leaving From">
			  </div>
			  <div class="control-group">
			      <input type="text" id="goingTo" name="goingTo" placeholder="Going To">
			  </div>
			</div>
			<div class="span3">
				<div class="control-group">
				      <input type="text" id="departing" name="departing" class="datepicker" placeholder="Departing">
			  	</div>
			</div>
			<div class="span3">
				<div class="control-group">
						<input type="submit" id="go" value="Go">
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
		$(document).ready(function(){	
	    	$( ".datepicker" ).datepicker();
	  	});
  	</script>
</z:layout>