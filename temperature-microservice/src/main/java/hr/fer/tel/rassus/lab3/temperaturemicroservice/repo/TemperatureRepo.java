package hr.fer.tel.rassus.lab3.temperaturemicroservice.repo;

import hr.fer.tel.rassus.lab3.temperaturemicroservice.domain.TemperatureData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepo extends JpaRepository<TemperatureData, Long> {
}
