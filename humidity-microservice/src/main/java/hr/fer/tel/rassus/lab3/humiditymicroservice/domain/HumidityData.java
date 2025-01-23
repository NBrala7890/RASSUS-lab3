package hr.fer.tel.rassus.lab3.humiditymicroservice.domain;

import jakarta.persistence.*;

@Entity
public class HumidityData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readingId;

    private String unit;

    private Integer humidityValue;

    public HumidityData() {
    }

    public HumidityData(String unit, Integer value) {
        this.unit = unit;
        this.humidityValue = value;
    }

    public Long getReadingId() {
        return readingId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getHumidityValue() {
        return humidityValue;
    }

    public void setHumidityValue(Integer humidityValue) {
        this.humidityValue = humidityValue;
    }
}
