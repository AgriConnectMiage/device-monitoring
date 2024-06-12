package fr.miage.acm.devicemonitoringservice.device.actuator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActuatorService {

    private ActuatorRepository actuatorRepository;


    public ActuatorService(ActuatorRepository actuatorRepository) {
        this.actuatorRepository = actuatorRepository;
    }

    public List<Actuator> findAll() {
        return actuatorRepository.findAll();
    }

    public Optional<Actuator> findById(UUID id) {
        return actuatorRepository.findById(id);
    }

    public List<Actuator> findByFarmerId(UUID farmerId) {
        return actuatorRepository.findByFarmerId(farmerId);
    }

}