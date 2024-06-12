package fr.miage.acm.devicemonitoringservice.device.actuator;

import fr.miage.acm.devicemonitoringservice.api.ApiActuator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/actuators")
public class ActuatorController {

    private final ActuatorService actuatorService;

    @Autowired
    public ActuatorController(ActuatorService actuatorService) {
        this.actuatorService = actuatorService;
    }

    @GetMapping
    public List<ApiActuator> getAllActuators() {
        return actuatorService.findAll().stream().map(ApiActuator::new).toList();
    }

    @GetMapping("/{id}")
    public Optional<ApiActuator> getActuatorById(@PathVariable UUID id) {
        return actuatorService.findById(id).map(ApiActuator::new);
    }

    // get all actuators by farmer
    @GetMapping("/farmer/{farmerId}")
    public List<ApiActuator> getActuatorsByFarmer(@PathVariable UUID farmerId) {
        return actuatorService.findByFarmerId(farmerId).stream().map(ApiActuator::new).toList();
    }

}
