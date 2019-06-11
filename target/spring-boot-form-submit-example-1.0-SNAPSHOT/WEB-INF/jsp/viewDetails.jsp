<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Appointment details</title>
</head>
<body>
	<h2>Details as submitted successfully</h2>
	<h4>First Name : ${firstName}</h4>
	<h4>Last Name : ${lastName}</h4>
	<br/><br/>
	<div>
		<div>
			Click <strong><a href="/patientForm">here</a></strong> to add an appointment.
		</div>
	</div>
	<div>
		<div>
			Click <strong><a href="/getAppointmentForm">here</a></strong> to lookup an appointment.
		</div>
	</div>
</body>
</html>
