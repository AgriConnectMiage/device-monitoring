package fr.miage.acm.devicemonitoringservice.device.actuator.watering.scheduler;

import fr.miage.acm.devicemonitoringservice.device.actuator.Actuator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WateringSchedulerService {

    private WateringSchedulerRepository wateringSchedulerRepository;

    public WateringSchedulerService(WateringSchedulerRepository wateringSchedulerRepository) {
        this.wateringSchedulerRepository = wateringSchedulerRepository;
    }

    // find by actuator
    public WateringScheduler findByActuator(Actuator actuator) {
        Optional<WateringScheduler> optionalWateringScheduler = wateringSchedulerRepository.findByActuator(actuator);
        if (optionalWateringScheduler.isEmpty()) {
            throw new RuntimeException("Watering scheduler not found for actuator with id: " + actuator);
        }
        WateringScheduler wateringScheduler = optionalWateringScheduler.get();
        return wateringScheduler;

    }
}