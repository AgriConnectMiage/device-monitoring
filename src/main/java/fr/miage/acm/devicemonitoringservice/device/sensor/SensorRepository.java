package fr.miage.acm.devicemonitoringservice.device.sensor;

import fr.miage.acm.devicemonitoringservice.farmer.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SensorRepository extends JpaRepository<Sensor, UUID> {
    void deleteByFarmer(Farmer farmer);

    List<Sensor> findByFarmer(Farmer farmer);

    List<Sensor> findAllByIdIn(List<UUID> ids);

    List<Sensor> findByFarmerId(UUID farmerId);
}
