<html>
<head>
<title>spring boot form submit example</title>
</head>
<body>
	<h2>Patient Details</h2>
	<form method="post" action="bookAppointment">
		First Name : <input type="text" name="firstName" /> <br>
		Last Name: <input type="text" name="lastName" /> <br> 
		Date of Birth: <input type="date" name="birthDate" /> <br>
		Appointment date time: <input type="date" name="appointmentDate" /> <input type="time" name="appointmentTime">
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>
