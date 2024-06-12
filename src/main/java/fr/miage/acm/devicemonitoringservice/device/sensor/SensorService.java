package fr.miage.acm.devicemonitoringservice.device.sensor;

import fr.miage.acm.devicemonitoringservice.device.DeviceState;
import fr.miage.acm.devicemonitoringservice.farmer.Farmer;
import fr.miage.acm.devicemonitoringservice.field.Field;
import fr.miage.acm.devicemonitoringservice.field.FieldRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SensorService {

    private SensorRepository sensorRepository;

    private FieldRepository fieldRepository;


    public SensorService(SensorRepository sensorRepository, FieldRepository fieldRepository) {
        this.sensorRepository = sensorRepository;
        this.fieldRepository = fieldRepository;
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> findById(UUID id) {
        return sensorRepository.findById(id);
    }

    public List<Sensor> findAllByIds(List<UUID> ids) {
        return sensorRepository.findAllByIdIn(ids);
    }

    public List<Sensor> findByFarmer(Farmer farmer) {
        return sensorRepository.findByFarmer(farmer);
    }

    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public void delete(Sensor sensor) {
        sensorRepository.delete(sensor);
    }
}
