<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<z:layout pageTitle="Canoe - Administration - Utilisateurs">
	<h1>Gestion des utilisateurs</h1>
	<hr />
	
	<c:if test="${param.del == 'ok'}">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			Votre demande de suppression a bien été prise en compte. Elle sera effective dans quelques instants.<br />
		    <div class="progress progress-striped active">
		    	<div class="bar" style="width: 0%;"></div>
		    </div>
		</div>
		<div class="del-msg"></div>
	</c:if>
	<c:if test="${param.del == 'ko'}">
		<div class="alert">KO</div>
	</c:if>
	
	<div class="pull-right" style="margin-bottom: 20px;">
		<a href="/auth/register.jsp" title="Ajouter un utilisateur" class="btn btn-success">
			Ajouter un utilisateur
		</a>
	</div>
    <table class="table">
    	<tr>
    		<th>#</th>
    		<th>Nom d'utilisateur</th>
    		<th>Nom</th>
    		<th>Inscription</th>
    		<th>Dernière activité</th>
    		<th>Administrateur</th>
    		<th>Action</th>
    	</tr>
    	<c:forEach var="user" items="${listUsers}">
    		<c:if test="${param.u != user.key}">
	    		<tr>
	    			<td></td>
	    			<td>${user.username}</td>
	    			<td>${user.firstname} ${user.lastname}</td>
	    			<td>${user.registerDate}</td>
	    			<td>${user.lastLoginDate}</td>
	    			<td><a href="/admin/users?adm=${user.key}" title="Toggle admin">
	    				<c:if test="${user.admin == true}">
	    					<i class="icon-ok"></i>
	    				</c:if>
	    				<c:if test="${user.admin != true}">
	    					<i class="icon-remove"></i>
	    				</c:if>	 
	    				</a>   				
	    			</td>
	    			<td>
	    				<c:if test="${user.key != User.key}">
	    					<a href="/admin/delete?u=${user.key}"><i class="icon-trash"></i></a>
	    				</c:if>
	    			</td>
	    		</tr>
    		</c:if>
    	</c:forEach>
    </table>
    <div class="pull-right" style="margin-top: 20px;">
		<a href="/auth/register.jsp" title="Ajouter un utilisateur" class="btn btn-success">
			Ajouter un utilisateur
		</a>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){		
			  var progress = setInterval(function() {
				    var $bar = $('.bar');

				    if ($bar.width()>890) {
				        clearInterval(progress);
				        $('.progress').removeClass('active');
				        $('.del-msg').hide();
				        $('.del-msg').addClass('alert alert-success')
				        $('.del-msg').html('<button type="button" class="close" data-dismiss="alert">&times;</button>Suppression effectuée avec succès !');
				        $('.del-msg').fadeIn('slow');
				    } else {
				        $bar.width($bar.width()+100);
				    }
				}, 500);
			  
			  $(".alert").alert()
		
		});
	</script>​
</z:layout>
<%-- 
<%@include file="template/header.html" %>


<%@include file="template/footer.html" %> --%>
