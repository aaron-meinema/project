package stenden.farm.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stenden.farm.data.model.Cow;

@Repository
public interface CowRepository extends JpaRepository<Cow, Long> {
}
