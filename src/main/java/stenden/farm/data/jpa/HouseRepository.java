package stenden.farm.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stenden.farm.data.model.House;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HouseRepository extends JpaRepository<House, Long> {
}
