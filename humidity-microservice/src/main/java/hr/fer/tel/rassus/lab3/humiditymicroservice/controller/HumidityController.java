package hr.fer.tel.rassus.lab3.humiditymicroservice.controller;

import hr.fer.tel.rassus.lab3.humiditymicroservice.dto.HumidityDataDto;
import hr.fer.tel.rassus.lab3.humiditymicroservice.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class HumidityController {

    @Autowired
    private HumidityService humidityService;

    @GetMapping(value = "/get-humidity-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HumidityDataDto> getHumidityData() {

        HumidityDataDto humidityDataDto = humidityService.getHumidityData();

        return new ResponseEntity<>(humidityDataDto, HttpStatus.FOUND);

    }

    @GetMapping(value = "/get-all-humidity-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HumidityDataDto>> getAllHumidityData() {

        return humidityService.getAllHumidityData();
    }

}
