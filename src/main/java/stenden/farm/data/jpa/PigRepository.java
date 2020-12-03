package stenden.farm.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stenden.farm.data.model.Pig;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PigRepository extends JpaRepository<Pig, Long> {
}
