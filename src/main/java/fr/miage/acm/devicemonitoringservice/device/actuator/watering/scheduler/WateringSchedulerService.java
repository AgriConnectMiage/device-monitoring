package fr.miage.acm.devicemonitoringservice.device.actuator.watering.scheduler;

import fr.miage.acm.devicemonitoringservice.device.actuator.Actuator;
import org.springframework.stereotype.Service;

@Service
public class WateringSchedulerService {

    private WateringSchedulerRepository wateringSchedulerRepository;

    public WateringSchedulerService(WateringSchedulerRepository wateringSchedulerRepository) {
        this.wateringSchedulerRepository = wateringSchedulerRepository;
    }
}