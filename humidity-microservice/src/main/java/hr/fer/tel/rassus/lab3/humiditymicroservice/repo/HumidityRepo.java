package hr.fer.tel.rassus.lab3.humiditymicroservice.repo;

import hr.fer.tel.rassus.lab3.humiditymicroservice.domain.HumidityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepo extends JpaRepository<HumidityData, Long> {
}
