package org.appointmentapp.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.appointmentapp.model.Appointment;
import org.appointmentapp.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by aaav
 */
@Controller
public class AppointmentController {
	@Autowired
	private AppointmentRepository appointmentRepository;

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @GetMapping("/patientForm")
    public String home() {
        return "patientForm";
    }

    @GetMapping("/getAppointmentForm")
    public String appointmentForm() {
        return "appointmentForm";
    }
    
	@PostMapping("/bookAppointment")
	public String bookAppointments(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("birthDate") String birthDate,
			@RequestParam("appointmentDate") String appointmentDate, @RequestParam("appointmentTime") String appointmentTime, ModelMap modelMap) {
		Appointment appointment = new Appointment();
		appointment.setFirstName(firstName);
		appointment.setLastName(lastName);
		appointment.setBirthDate(LocalDate.parse(birthDate));
		appointment.setAppointmentDate(LocalDate.parse(appointmentDate));
		appointment.setAppointmentTime(LocalTime.parse(appointmentTime));
		Appointment savedAppointment = appointmentRepository.save(appointment);
		modelMap.put("appointmentId", savedAppointment.getId());
		return "appointmentConfirmation";
	}

	
	@PostMapping("/getAppointmentDetails")
	public String getAppointmentDetails(@RequestParam("appointmentId") String appointmentId,
			ModelMap modelMap) { 
		Appointment appointment = appointmentRepository.findOne(Long.parseLong(appointmentId));
		
		if(appointment != null) {
			modelMap.put("result", "Appointment found:");
			modelMap.put("firstName", appointment.getFirstName());
			modelMap.put("lastName", appointment.getLastName());
			modelMap.put("birthDate", appointment.getBirthDate());
			modelMap.put("appointmentDate", appointment.getAppointmentDate());
			modelMap.put("appointmentTime", appointment.getAppointmentTime());
		}
		else {
			modelMap.put("result", "No appointment found...");
		}
		
		return "viewDetails";
	}
	 
}
