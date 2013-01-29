<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<z:layout pageTitle="Gestion des vols">
	<h1>Search a Flight</h1>
	<hr />

	<!-- Onglet Ajout ou Recherche -->
	<ul class="nav nav-tabs">
		<c:if test="${User.admin}">
			<li><a href="/admin/flight-add">Ajout</a></li>
		</c:if>
		<!-- Zone de recherche d'un vol -->
		<li class="active"><a href="/flight/flight-search">Recherche</a>
		</li>
		<li><a href="/flight/history">Historique</a></li>
	</ul>

	<form class="form-horizontal" action="/flight/flight-search"
		method="post">


		<!-- From -> To -->

		<div class="row-fluid">
			<div class="span3">
				<div class="control-group">
					<input type="text" id="leavingFrom" name="leavingFrom"
						placeholder="Leaving From">
				</div>
			</div>
			<div class="span1">
				<i class="icon-play"></i><i class="icon-play"></i><i
					class="icon-play"></i><i class="icon-play"></i>
			</div>
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
					<input type="text" id="returnDate" name="returnDate"
						class="datepicker" placeholder="Return Date">
				</div>
			</div>
			<div class="span2">
				<div class="control-group">
					<button class="btn btn-success" type="submit" id="go">
						<i class="icon-search icon-white"></i> Search
					</button>
				</div>
			</div>
		</div>
		<label class="checkbox"> <input type="checkbox" id="return"
			name="return" onclick="test()" /> Return
		</label>

	</form>

	<hr />
	<div class="Well" id="goTable">
	<h3>From ${from} to ${to} </h3>
	
		<table class="table table-striped table-bordered table-hover">
			<THEAD>
				<tr>
					<th>Date</th>
					<th>Departure Town</th>
					<th>Arrival Town</th>
					<th>Flight duration</th>
					<th>Available seats</th>
					<th>Price</th>
					<th>Book</th>					
				</tr>
			</THEAD>
			<TBODY>
				<c:forEach var="entry" items="${departs}">
					<tr class="entryFirstTable">
						<fmt:formatDate value="${entry.duration}" pattern="dd/MM/yy HH:mm" var="fDate2" />
						<td>${fDate2 }</td>
						<td>${entry.from }</td>
						<td>${entry.to }</td>
												
						<td>
							<fmt:formatDate value="${entry.duration}" pattern="dd' jours et' HH'h'mm" var="duration" />
							${duration }
						</td>
						<td>${entry.availableSeats }</td>
						<td>${entry.price } €</td>
						<td><a href="/flight/flight-reserve?flightId=${entry.key}" class="btn btn-info"><i class="icon-plane icon-white"></i> Reserve</a></td>
					</tr>
				</c:forEach>
			</TBODY>
		</table>
	</div>
	<!-- RETURN -->
	<div id="returnTable">
		<h3>Return <i class="icon-play"></i><i class="icon-play"></i> From ${to} to ${from}</h3>
		<div class="Well">
			<table class="table table-striped table-bordered tabel-hover">
				<THEAD>
					<tr>
						<th>Date</th>
						<th>Departure Town</th>
						<th>Arrival Town</th>
						<th>Flight duration</th>
						<th>Available seats</th>
						<th>Price</th>
						<th>Book</th>						
					</tr>
				</THEAD>
				<TBODY>
					<c:forEach var="entry" items="${requestScope['returns']}">
						<tr>
							<fmt:formatDate value="${entry.duration}" pattern="dd/MM/yy HH:mm" var="fDate1" />
							<td>${fDate1 }</td>
							<td>${entry.from }</td>
							<td>${entry.to }</td>
							<td>
								<fmt:formatDate value="${entry.duration}" pattern="dd' jours et' HH'h'mm" var="duration" />
								${duration}
							</td>
							<td>${entry.availableSeats }</td>
							<td>${entry.price } €</td>
							<td>
								<c:if test="${isReturn}">					
									<a href="#" class="btn btn-info"><i class="icon-plane icon-white"></i> Reserve</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</TBODY>
			</table>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$(".datepicker").datepicker();
			$("#returnDate").hide();			
			if( $(".entryFirstTable").length < 1 ) {
				$("#goTable").hide();
				$("#returnTable").hide();
			}
		});

		function test() {
			$("#returnDate").toggle();			
		}
	</script>
</z:layout>