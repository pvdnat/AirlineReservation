<nav class="nav nav-pills nav-justified">
	<a class="nav-item nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
	<a class="nav-item nav-link" href="${pageContext.request.contextPath}/airlinesForm">Airlines Form</a>
	<a class="nav-item nav-link" href="${pageContext.request.contextPath}/airportForm">Airport Form</a>
	<a class="nav-item nav-link" href="${pageContext.request.contextPath}/flightForm">Flight Form</a>

	<sec:authorize access="isAuthenticated()">
  		<a class="nav-item nav-link" href="${pageContext.request.contextPath}/passengerForm">Passenger Form</a>
  	</sec:authorize>
  	
  	<sec:authorize access="!isAuthenticated()">
  		<a class="nav-item nav-link" href="${pageContext.request.contextPath}/login">Passenger Form</a>
  	</sec:authorize>
  	
  	<sec:authorize access="isAuthenticated()">
  		<a class="nav-item nav-link" href="${pageContext.request.contextPath}/reservationHistory">Reservation History</a>
  	</sec:authorize>
  	<sec:authorize access="!isAuthenticated()">
  		<a class="nav-item nav-link" href="${pageContext.request.contextPath}/login">Reservation History</a>
  	</sec:authorize>
  	
  	<sec:authorize access="isAuthenticated()">
		<a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
  		<a class="nav-item nav-link" href="${pageContext.request.contextPath}/login">Login</a>
  	</sec:authorize>
</nav>


