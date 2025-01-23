package hr.fer.tel.rassus.lab3.temperaturemicroservice.controller;

import hr.fer.tel.rassus.lab3.temperaturemicroservice.dto.TemperatureDataDto;
import hr.fer.tel.rassus.lab3.temperaturemicroservice.service.TemperatureService;
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
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping(value = "/get-temperature-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureDataDto> getTempData () {

        TemperatureDataDto temperatureDataDto = temperatureService.getTempData();

        return new ResponseEntity<>(temperatureDataDto, HttpStatus.FOUND);

    }

    @GetMapping(value = "/get-all-temperature-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TemperatureDataDto>> getAllTempData () {

        return temperatureService.getAllTemperatureData();

    }

}
