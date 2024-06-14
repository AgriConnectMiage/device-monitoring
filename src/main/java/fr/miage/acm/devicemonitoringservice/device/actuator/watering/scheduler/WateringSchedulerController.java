package fr.miage.acm.devicemonitoringservice.device.actuator.watering.scheduler;

import fr.miage.acm.devicemonitoringservice.api.ApiWateringScheduler;
import fr.miage.acm.devicemonitoringservice.device.actuator.Actuator;
import fr.miage.acm.devicemonitoringservice.device.actuator.ActuatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/actuators/{actuatorId}/watering-scheduler")
public class WateringSchedulerController {

    private WateringSchedulerService wateringSchedulerService;
    private ActuatorService actuatorService;

    public WateringSchedulerController(WateringSchedulerService wateringSchedulerService, ActuatorService actuatorService) {
        this.wateringSchedulerService = wateringSchedulerService;
        this.actuatorService = actuatorService;
    }

    @GetMapping()
    public WateringScheduler getWateringScheduler(@PathVariable UUID actuatorId) {
        Optional<Actuator> optionalActuator = actuatorService.findById(actuatorId);
        if (optionalActuator.isEmpty()) {
            System.out.println("dedans2");
            throw new RuntimeException("Actuator not found with id: " + actuatorId);
        }
        WateringScheduler wateringScheduler = wateringSchedulerService.findByActuator(optionalActuator.get());
        return wateringScheduler;
    }

}
