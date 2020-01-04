package im.vtngsystm.repository;

import im.vtngsystm.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Integer> {

    Election findElectionByDateAndType(LocalDate localDate, String type);

    @Query("SELECT e FROM Election e ORDER BY e.date DESC")
    List<Election> findAllByDateChronology();

    @Query("SELECT e FROM Election e WHERE e.date=?1")
    Election findElectionByDate(LocalDate date);
}
