package hr.fer.tel.rassus.lab3.humiditymicroservice.service;

import hr.fer.tel.rassus.lab3.humiditymicroservice.domain.HumidityData;
import hr.fer.tel.rassus.lab3.humiditymicroservice.dto.HumidityDataDto;
import hr.fer.tel.rassus.lab3.humiditymicroservice.repo.HumidityRepo;
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
public class HumidityService {

    private static final Logger logger = Logger.getLogger(HumidityService.class.getName());

    @Autowired
    private HumidityRepo humidityRepo;

    @PostConstruct
    public void loadCSVData() {

        ArrayList<HumidityData> allHumidityReadings = new ArrayList<>();

        try {

            // Reading all the lines from the readings.csv file
            List<String> allLines = Files.readAllLines(Paths.get("/app/data/readings.csv"));

            // Removing the first line from the readings.csv file
            allLines.removeFirst();

            for (String line : allLines) {

                // Checking if the data has been loaded successfully
                logger.info(line);

                // Extracting and storing the humidity reading
                allHumidityReadings.add(new HumidityData("%", Integer.parseInt(line.split(",", -1)[2])));

            }

            // Storing all the read data to database
            humidityRepo.saveAll(allHumidityReadings);

            System.out.println("CSV data loaded successfully.");

        }
        catch (Exception e) {

            logger.severe("An error has occurred while reading from a CSV file. " + e.getMessage() + "\n");

        }

    }

    public HumidityDataDto getHumidityData() {

        try {

            // Calculating the index based on the given formula
            int index = (int) Duration.between(Instant.EPOCH, Instant.now()).toMinutes() % 100;

            // Getting the humidity data at the calculated index
            HumidityData humidityData = humidityRepo.findAll().get(index);

            return new HumidityDataDto("Humidity", humidityData.getUnit(), humidityData.getHumidityValue());

        }
        catch (Exception e) {

            logger.severe("Getting the data from the database failed.\n");
            return null;

        }

    }

    public ResponseEntity<List<HumidityDataDto>> getAllHumidityData() {

        List<HumidityData> allHumidityDataList = humidityRepo.findAll();

        List<HumidityDataDto> allHumidityDataDtoList = allHumidityDataList.stream()
                .map(humidityData -> new HumidityDataDto("Humidity", humidityData.getUnit(), humidityData.getHumidityValue()))
                .toList();

        return new ResponseEntity<>(allHumidityDataDtoList, HttpStatus.OK);

    }

}
