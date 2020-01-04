package im.vtngsystm.repository;

import im.vtngsystm.entity.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestantRepository extends JpaRepository<Contestant, Integer> {

    Contestant findContestantByNameEquals(String name);
}
