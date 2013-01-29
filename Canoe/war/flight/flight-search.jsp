<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<z:layout pageTitle="Gestion des vols">
	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<c:if test="${admin}">
			<li><a href="/admin/flight-add">Ajout</a></li>
		</c:if>
		<!-- Zone de recherche d'un vol -->
		<li class="active"><a href="/flight/flight-search">Recherche</a>
		</li>
		<li>
			<a href="/flight/history">Historique</a>
		</li>
	</ul>

	<form class="form-horizontal" action="/admin/flight-search"
		method="post">


		<!-- From -> To -->

		<div class="row-fluid">
			<div class="span3">
				<div class="control-group">
					<input type="text" id="leavingFrom" name="leavingFrom"
						placeholder="Leaving From">
				</div>
			</div>
			<div class="span1"><i class="icon-play"></i><i class="icon-play"></i><i class="icon-play"></i><i class="icon-play"></i></div>
			<div class="span3">
				<div class="control-group">
					<input type="text" id="goingTo" name="goingTo"
						placeholder="Going To">
				</div>
			</div>
		</div>
		<!-- date : departing , return -->
		<div class="row-fluid">
			<div class="span3">
				<div class="control-group">
					<input type="text" id="departingDate" name="departingDate"
						class="datepicker" placeholder="Departing Date">
				</div>
			</div>
			<div class="span1"></div>
			<div class="span3">
				<div class="control-group">
					<input type="text" id="returnDate" name="returnDate" class="datepicker"
						placeholder="Return Date">
				</div>
			</div>			
			<div class="span2">
				<div class="control-group">					
					<button class="btn btn-success" type="submit" id="go" ><i class="icon-search icon-white"></i> Search </button>
				</div>
			</div>
		</div>
		 <label class="checkbox">
			<input type="checkbox" id="return" name="return" onclick="test()"/> Return
		</label>

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
	    	$("#returnDate").hide();
	  	});		
		
		function test(){
			$("#returnDate").toggle();
		}
  	</script>
</z:layout>