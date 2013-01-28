<%@ tag body-content="scriptless" %>
<%@ attribute name="pageTitle" required="true" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${pageTitle}</title>
<!-- Bootstrap -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"	media="screen" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
</head>
<body>
	<div class="navbar">
			<div class="navbar-inner">
			<div class="container">		
				<a class="brand" href="/index.jsp">Title</a>
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
				</ul>
				<c:if test="${User.username == null}">
					<div class="nav pull-right">			
						<a href="/auth/login.jsp" class="btn btn-success">Login</a>
						<a href="/auth/register.jsp" class="btn btn-info">Register</a>			
					</div>
				</c:if>
				<c:if test="${User.username != null}">
					<div class="nav pull-right">			
						<ul class="nav"><li><a href="#" style="cursor: default;">Bienvenue ${User.firstname} !</a></li></ul>
						<a href="/auth/logout" class="btn btn-danger">Se déconnecter</a>			
					</div>
				</c:if>
			</div>
			</div>
		</div>
	</div>
	<div class="container">		
    	<jsp:doBody/>
    </div>
<footer>
	<div class="navbar navbar-fixed-bottom">
	    <ul class="breadcrumb">
	    <li><a href="#">Home</a> <span class="divider">/</span></li>
	    <li><a href="#">Library</a> <span class="divider">/</span></li>
	    <li class="active">Data</li>
	    </ul>
    </div>
</footer>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
