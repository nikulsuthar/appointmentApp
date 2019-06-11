/**
 * 
 */
package org.appointmentapp.repository;

import org.appointmentapp.model.Appointment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author aaav
 *
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
