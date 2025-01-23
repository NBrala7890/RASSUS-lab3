package hr.fer.tel.rassus.lab3.aggregatormicroservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemperatureDataDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("value")
    private Integer value;

    public TemperatureDataDto() {
    }

    public TemperatureDataDto(String name, String unit, Integer value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
