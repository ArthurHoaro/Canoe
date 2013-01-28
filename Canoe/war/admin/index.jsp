<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<z:layout pageTitle="Canoe - Administration">
	<h1>Console d'administration</h1>
	<hr />
	<div class="row">

		<div class="span6" style="text-align: center;">
			<div class="well">
				<a href="/admin/users" class="btn btn-primary btn-large">Gérer les utilisateurs</a>
			</div>
		</div>
		<div class="span6" style="text-align: center;">
			<div class="well">
				<a href="/admin/flight-add" class="btn btn-primary btn-large">Gérer les vols</a>

			</div>
		</div>
	</div>

</z:layout>
<%-- 
<%@include file="template/header.html" %>


<%@include file="template/footer.html" %> --%>
