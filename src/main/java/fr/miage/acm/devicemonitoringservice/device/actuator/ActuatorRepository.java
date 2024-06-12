package fr.miage.acm.devicemonitoringservice.device.actuator;

import fr.miage.acm.devicemonitoringservice.farmer.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActuatorRepository extends JpaRepository<Actuator, UUID> {
    
        List<Actuator> findByFarmer(Farmer farmer);
    
        void deleteByFarmer(Farmer farmer);

}
