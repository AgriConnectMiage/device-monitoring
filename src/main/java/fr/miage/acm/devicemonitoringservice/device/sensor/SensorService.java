package fr.miage.acm.devicemonitoringservice.device.sensor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SensorService {

    private SensorRepository sensorRepository;



    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> findById(UUID id) {
        return sensorRepository.findById(id);
    }

    public List<Sensor> findByFarmerId(UUID farmerId) {
        return sensorRepository.findByFarmerId(farmerId);
    }
}
