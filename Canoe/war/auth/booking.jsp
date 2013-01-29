<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<z:layout pageTitle="Bookings">
	<h1>Bookings</h1>
	<hr />
	
	<div class="Well">
		<table class="table table-striped table-bordered table-hover">
			<THEAD>
				<tr>
					<th>Date</th>
					<th>Flight details</th>
					<th>Number of seats booked</th>				</tr>
			</THEAD>
			<TBODY>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>
					<fmt:formatDate value="${book.date}" pattern="dd/MM/yyyy" var="date" /> 
					${date}
					</td>
					<td><a href="/flight/flight-reserve?flightId=${book.flightKey}&cons=1" class="btn btn-small btn-info">Details</a></td>
					<td>${book.numberOfSeats}</td>					
				</tr>
			
			</c:forEach>
				

			</TBODY>
		</table>
	</div>
	
</z:layout>
