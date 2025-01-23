package hr.fer.tel.rassus.lab3.aggregatormicroservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AggregatedDataDto {

    @JsonProperty("temperatureData")
    private TemperatureDataDto temperatureDataDto;

    @JsonProperty("humidityData")
    private HumidityDataDto humidityDataDto;

    public AggregatedDataDto() {

    }

    public AggregatedDataDto(TemperatureDataDto temperatureDataDto, HumidityDataDto humidityDataDto) {
        this.temperatureDataDto = temperatureDataDto;
        this.humidityDataDto = humidityDataDto;
    }

    @Override
    public String toString() {
        return "AggregatedDataDto { " +
                "temperatureData = " + temperatureDataDto +
                ", humidityData = " + humidityDataDto +
                " } ";
    }

}
