<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout pageTitle="Canoë - Profil - Modifications">
	<h1>Modification du profil</h1>
	<hr />	
	
	<c:if test="${error != null}">
		<div class="alert alert-error">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${error}
		</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${success}
		</div>
	</c:if>
	
	<form class="form-horizontal" action="/auth/edit" method="post">
		<div class="control-group">
			<label class="control-label" for="pass">Mot de passe <span class="label label-important">Obligatoire</span></label>
			<div class="controls">
				<input type="password" id="pass" name="pass" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="username">Nom d'utilisateur</label>
			<div class="controls">
				<input type="text" id="username"  name="username" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="firstname">Prénom</label>
			<div class="controls">
				<input type="text" id="firstname" name="firstname" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="lastname">Nom</label>
			<div class="controls">
				<input type="text" id="lastname" name="lastname" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="birthday">Date de naissance <span class="label label-info">(JJ/MM/YYYY)</span></label>
			<div class="controls">
				<input type="number" id="birthday" name="birthday" class="datepicker">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="mail">Email</label>
			<div class="controls">
				<input type="text" id="mail" name="mail" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="newpass">Nouveau mot de passe</label>
			<div class="controls">
				<input type="password" id="newpass" name="newpass" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="renewpass">Retapez le mot de passe</label>
			<div class="controls">
				<input type="password" id="renewpass" name="renewpass" >
			</div>
		</div>
		
		<input type="hidden" name="key" value="${User.key}" />
		<div class="control-group">
			<div class="controls">		
				<button type="submit" class="btn btn-success">Enregistrer</button>
			</div>
		</div>
	</form>
	
	<script>
		$(document).ready(function(){	
	    	$( ".datepicker" ).datepicker({ defaultDate: "-25y", changeYear: true });
	  	});
  	</script>
</z:layout>
