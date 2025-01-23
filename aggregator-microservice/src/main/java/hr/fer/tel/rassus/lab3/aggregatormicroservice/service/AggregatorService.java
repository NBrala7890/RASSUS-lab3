package hr.fer.tel.rassus.lab3.aggregatormicroservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AggregatorService {

    @Value("${server.port}")
    private String serverPort;

    @Value("${temperature-unit}")
    private String temperatureUnit;

    @Value("${temperature-URL}")
    private String temperatureURL;

    @Value("${humidity-URL}")
    private String humidityURL;

    private static final Logger logger = Logger.getLogger(AggregatorService.class.getName());

    @PostConstruct
    public void propertiesLoadCheck() {

        try {

            logger.info("\n\n\n" + serverPort + "\n\n\n");
            logger.info("\n\n\n" + temperatureUnit + "\n\n\n");
            logger.info("\n\n\n" + temperatureURL + "\n\n\n");
            logger.info("\n\n\n" + humidityURL + "\n\n\n");

        }
        catch (Exception e) {

            logger.severe("An error has occurred while testing. " + e.getMessage() + "\n");

        }

    }

}
