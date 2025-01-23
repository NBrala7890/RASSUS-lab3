package hr.fer.tel.rassus.lab3.temperaturemicroservice.domain;

import jakarta.persistence.*;

@Entity
public class TemperatureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readingId;

    private String unit;

    private Integer tempValue;

    public TemperatureData(String unit, Integer value) {
        this.unit = unit;
        this.tempValue = value;
    }

    public TemperatureData() {

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

    public Integer getTempValue() {
        return tempValue;
    }

    public void setTempValue(Integer tempValue) {
        this.tempValue = tempValue;
    }

}
