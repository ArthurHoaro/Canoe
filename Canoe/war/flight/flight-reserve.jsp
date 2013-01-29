<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<z:layout pageTitle="Gestion des vols">
	<h1>Flight Reservation</h1>
	<hr />
	<div class="Well">
		<table class="table table-striped table-bordered table-hover">
			<THEAD>
				<tr>
					<th>Date</th>
					<th>Departure Town</th>
					<th>Arrival Town</th>
					<th>Flight duration</th>
					<th>Available seats</th>
					<th>Price (€)</th>

				</tr>
			</THEAD>
			<TBODY>

				<tr>
					<td>${flight.dateDepart }</td>
					<td>${flight.from }</td>
					<td>${flight.to }</td>

					<td><fmt:formatDate value="${flight.duration}"
							pattern="dd' jours et' HH'h'mm" var="duration" /> ${duration }</td>
					<td>${flight.availableSeats }</td>
					<td>${flight.price }</td>

				</tr>

			</TBODY>
		</table>
	</div>

	<form class="form-horizontal" action="/flight/flight-reserve"
		method="post">
		<button class="btn btn-success span2" type="submit" id="confirm">
						<i class="icon-search icon-white"></i> Confirm
					</button>
	</form>


	<script>
		$(document).ready(function() {
			$(".datepicker").datepicker();
			$("#returnDate").hide();
		});

		function test() {
			$("#returnDate").toggle();
		}
	</script>
</z:layout>