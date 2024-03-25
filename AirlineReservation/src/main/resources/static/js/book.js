$(document).ready(function(){
	$("#flightTable").on('click', '.book', function() {
		var flightId = $(this).closest("tr").find("td:eq(0)").text();
		alert(flightId);
	})
})