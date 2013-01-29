<%@ tag import="cpe.canoe.listener.SessionCounterListener"%>
<%@ tag body-content="scriptless"%>
<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${pageTitle}</title>
<!-- Bootstrap -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<script src="/js/timepicker.js"></script>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="/index.jsp">Canoë</a>
				<ul class="nav">
					<li><a href="/index.jsp">Home</a></li>
					<li><a href="/flight/flight-search">Find a Flight</a></li>
					<li><a href="/auth/booking">Bookings</a></li>
					<c:if test="${User.admin == true}">
						<li><a href="/admin/index">Administration</a></li>
					</c:if>
				</ul>
				<c:if test="${User.username == null}">
					<div class="nav pull-right">
						<a href="/auth/login.jsp" class="btn btn-success">Login</a> <a
							href="/auth/register.jsp" class="btn btn-info">Register</a>
					</div>
				</c:if>
				<c:if test="${User.username != null}">
					<div class="nav pull-right">
						<ul class="nav">
							<li>
								<div class="dropdown-toggle btn btn-primary"
									data-toggle="dropdown">Bienvenue ${User.firstname} !</div>
								<ul class="dropdown-menu">
									<li><a href="#" style="cursor: default;">Connecté
											depuis <%=((int) (((new java.util.Date()).getTime() / 60000) - (((cpe.canoe.model.User) request
						.getSession().getAttribute("User")).getLastLoginDate()
						.getTime() / 60000)))%>
											minutes
									</a></li>
									<%
										SessionCounterListener counter = (SessionCounterListener) session
													.getAttribute("counter");
									%>
									<li><a href="#" style="cursor: default;"><%=counter.getNb()%>
											utilisateurs connectés</a></li>
									<li><a href="/auth/edit">Gérer mon profil</a></li>
									<li><a href="/flight/history">Historique des
											recherches</a></li>
								</ul>
							</li>
						</ul>
						<a href="/auth/logout" class="btn btn-danger">Se déconnecter</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<div class="container">
		<jsp:doBody />
	</div>
	<footer>
	<div class="footer navbar -navbar-fixed-bottom">
		<p class="offset3">
			Canoë <i class="icon-chevron-right"></i> Réservation de vols en ligne
			<i class="icon-chevron-right"></i> 2013
		</p>
	</div>
	</footer>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
