package fr.miage.acm.devicemonitoringservice.api;

import fr.miage.acm.devicemonitoringservice.device.DeviceState;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class ApiDevice {

    private UUID id;

    private DeviceState state;

    private ApiFarmer farmer;

    public ApiDevice(ApiFarmer farmer) {
        this.state = DeviceState.NOT_ASSIGNED;
        this.farmer = farmer;
    }

    public ApiDevice() {
        // Default constructor required by JPA
    }
}
