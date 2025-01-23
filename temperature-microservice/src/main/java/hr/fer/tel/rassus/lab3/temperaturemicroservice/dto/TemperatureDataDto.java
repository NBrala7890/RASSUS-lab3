package hr.fer.tel.rassus.lab3.temperaturemicroservice.dto;

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

}
