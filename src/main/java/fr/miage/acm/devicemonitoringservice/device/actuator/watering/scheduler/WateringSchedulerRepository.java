package fr.miage.acm.devicemonitoringservice.device.actuator.watering.scheduler;

import fr.miage.acm.devicemonitoringservice.device.actuator.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WateringSchedulerRepository extends JpaRepository<WateringScheduler, UUID> {

        // find by actuator id
        Optional<WateringScheduler> findByActuator(Actuator actuator);
}
