package hr.fer.tel.rassus.lab3.aggregatormicroservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HumidityDataDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("value")
    private Integer value;

    public HumidityDataDto() {
    }

    public HumidityDataDto(String name, String unit, Integer value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

}
