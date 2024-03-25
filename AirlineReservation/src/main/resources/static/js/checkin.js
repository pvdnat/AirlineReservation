$(document).ready(function(){
	$("#checkInTable").on('click', '.checkInButton', function() {
		
		var resNum = $(this).closest("tr").find("td:eq(0)").text();
		var status = $(this).closest("tr").find("td:eq(4)").text();
		var bag = $(this).closest("tr").find("td:eq(3)").text();

		
		$("#resNum").text(resNum);
		$("#checkInStatus").val(status);
		$("#checkedBag").val(bag);
		$("#checkInModal").show();
	})
	
	$("#checkInSubmit").click(function() {
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "http://localhost:2009/van/checkIn?reservationId=" + $("#resNum").text() +"&status="+$("#checkInStatus").val()+"&bags="+$("#checkedBag").val(),
			success: function(result) {
				$("#checkInModal").hide();
				location.reload();
			}, error: function(e) {
				alert("Fail to Check In");
			}
		});
	});
	
	$("#closeX").click(function() {
		$("#checkInModal").hide();
	});
	
	$("#closeButton").click(function() {
		$("#checkInModal").hide();
	});
})