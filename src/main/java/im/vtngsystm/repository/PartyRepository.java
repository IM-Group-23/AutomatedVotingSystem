package im.vtngsystm.repository;

import im.vtngsystm.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, String> {
}
