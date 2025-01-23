package hr.fer.tel.rassus.lab3.aggregatormicroservice.controller;

import hr.fer.tel.rassus.lab3.aggregatormicroservice.dto.AggregatedDataDto;
import hr.fer.tel.rassus.lab3.aggregatormicroservice.dto.HumidityDataDto;
import hr.fer.tel.rassus.lab3.aggregatormicroservice.dto.TemperatureDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/aggregation")
public class AggregationController {

    @Value("${temperature-unit}")
    private String temperatureUnit;

    @Value("${temperature-URL}")
    private String temperatureURL;

    @Value("${humidity-URL}")
    private String humidityURL;

    @Autowired
    RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(AggregationController.class);

    @GetMapping("/test")
    public String test() {

        return "I am available.";

    }

    @GetMapping("/get-aggregated-data")
    public ResponseEntity<AggregatedDataDto> getAggregatedData() {

        logger.info("\n\n\nReceived request for aggregated data.\n\n\n");

        TemperatureDataDto tempDataDto = restTemplate.getForObject(temperatureURL, TemperatureDataDto.class);

        HumidityDataDto humidityDataDto = restTemplate.getForObject(humidityURL, HumidityDataDto.class);

        // Managing the conversion between K and C
        if (temperatureUnit.equals("K")) {
            tempDataDto.setValue(tempDataDto.getValue() + 273);
            tempDataDto.setUnit("K");
        }

        AggregatedDataDto aggregatedDataDto = new AggregatedDataDto(tempDataDto, humidityDataDto);

        return new ResponseEntity<>(aggregatedDataDto, HttpStatus.OK);
    }

}
