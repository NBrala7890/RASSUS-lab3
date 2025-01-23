package hr.fer.tel.rassus.lab3.temperaturemicroservice.service;

import hr.fer.tel.rassus.lab3.temperaturemicroservice.domain.TemperatureData;
import hr.fer.tel.rassus.lab3.temperaturemicroservice.dto.TemperatureDataDto;
import hr.fer.tel.rassus.lab3.temperaturemicroservice.repo.TemperatureRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TemperatureService {

    private static final Logger logger = Logger.getLogger(TemperatureService.class.getName());

    @Autowired
    private TemperatureRepo temperatureRepo;

    @PostConstruct
    public void loadCSVData() {

        ArrayList<TemperatureData> allTemperatureReadings = new ArrayList<>();

        try {

            // Reading all the lines from the readings.csv file
            List<String> allLines = Files.readAllLines(Paths.get("/app/data/readings.csv"));

            // Removing the first line from the readings.csv file
            allLines.removeFirst();

            for (String line : allLines) {

                // Checking if the data has been loaded successfully
                logger.info(line);

                // Extracting and storing the temperature reading
                allTemperatureReadings.add(new TemperatureData("C", Integer.parseInt(line.split(",", -1)[0])));

            }

            // Storing all the read data to database
            temperatureRepo.saveAll(allTemperatureReadings);

            System.out.println("CSV data loaded successfully.");

        }
        catch (Exception e) {

            logger.severe("An error has occurred while reading from a CSV file. " + e.getMessage() + "\n");

        }

    }

    public TemperatureDataDto getTempData() {

        try {

            // Calculating the index based on the given formula
            int index = (int) Duration.between(Instant.EPOCH, Instant.now()).toMinutes() % 100;

            // Getting the temperature data at the calculated index
            TemperatureData temperatureData = temperatureRepo.findAll().get(index);

            return new TemperatureDataDto("Temperature", temperatureData.getUnit(), temperatureData.getTempValue());

        }
        catch (Exception e) {

            logger.severe("Getting the data from the database failed.\n");
            return null;

        }

    }

    public ResponseEntity<List<TemperatureDataDto>> getAllTemperatureData() {

        // Retrieving all the entries from the database
        List<TemperatureData> allTemperatureDataList = temperatureRepo.findAll();

        List<TemperatureDataDto> allTemperatureDataDtoList = allTemperatureDataList.stream()
                .map(tempData -> new TemperatureDataDto("Temperature", tempData.getUnit(), tempData.getTempValue()))
                .toList();

        return new ResponseEntity<>(allTemperatureDataDtoList, HttpStatus.OK);

    }

}
