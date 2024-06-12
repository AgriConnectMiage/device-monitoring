package fr.miage.acm.devicemonitoringservice.farmer;

import fr.miage.acm.devicemonitoringservice.device.actuator.ActuatorService;
import fr.miage.acm.devicemonitoringservice.device.sensor.SensorService;
import fr.miage.acm.devicemonitoringservice.field.Field;
import fr.miage.acm.devicemonitoringservice.field.FieldService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FarmerService {

    private FarmerRepository farmerRepository;

    private FieldService fieldService;
    private SensorService sensorService;
    private ActuatorService actuatorService;

    public FarmerService(FarmerRepository farmerRepository, FieldService fieldService, SensorService sensorService, ActuatorService actuatorService) {
        this.farmerRepository = farmerRepository;
        this.fieldService = fieldService;
        this.sensorService = sensorService;
        this.actuatorService = actuatorService;
    }

    public List<Farmer> findAll() {
        return farmerRepository.findAll();
    }

    public Optional<Farmer> findById(UUID id) {
        return farmerRepository.findById(id);
    }

    public Farmer findByEmail(String email) {
        return farmerRepository.findByEmail(email);
    }

    public Farmer save(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public void deleteById(UUID id) {
        farmerRepository.deleteById(id);
    }

    public void delete(Farmer farmer) {
        farmerRepository.delete(farmer);
    }


    public Farmer createFarmer(String firstName, String lastName, String email, String password, int fieldSize) {
        Farmer farmerSearch = findByEmail(email);
        if (farmerSearch == null) {
            Farmer farmer = new Farmer(firstName, lastName, email, password, fieldSize);
            this.save(farmer);
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    Field field = new Field(i + 1, j + 1, farmer);
                    fieldService.save(field);
                }
            }
            return farmer;
        } else {
            System.out.println("Farmer already exists");
        }
        return null;
    }


    public void editPassword(UUID id, String password) {
        Optional<Farmer> farmerOptional = farmerRepository.findById(id);
        if (farmerOptional.isPresent()) {
            Farmer farmer = farmerOptional.get();
            farmer.setPassword(password);
            farmerRepository.save(farmer);
        }
    }
}
