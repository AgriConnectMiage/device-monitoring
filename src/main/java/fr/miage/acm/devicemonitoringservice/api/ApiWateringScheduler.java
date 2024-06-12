package fr.miage.acm.devicemonitoringservice.api;

import java.time.LocalDateTime;
import java.util.UUID;

public class ApiWateringScheduler {
    private UUID id;

    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    private float duration;

    private Integer humidityThreshold;

    public ApiWateringScheduler(UUID id, LocalDateTime beginDate, LocalDateTime endDate, float duration, Integer humidityThreshold) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.duration = duration;
        this.humidityThreshold = humidityThreshold;
    }


}
