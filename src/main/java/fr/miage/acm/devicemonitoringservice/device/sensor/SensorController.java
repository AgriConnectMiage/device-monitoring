package fr.miage.acm.devicemonitoringservice.device.sensor;

import fr.miage.acm.devicemonitoringservice.api.ApiSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public List<ApiSensor> getAllSensors() {
        return sensorService.findAll().stream().map(ApiSensor::new).toList();
    }

    @GetMapping("/{id}")
    public Optional<Sensor> getSensorById(@PathVariable UUID id) {
        return sensorService.findById(id);
    }

    @GetMapping("/farmer/{farmerId}")
    public List<ApiSensor> getSensorsByFarmer(@PathVariable UUID farmerId) {
        return sensorService.findByFarmerId(farmerId).stream().map(ApiSensor::new).toList();
    }
}
