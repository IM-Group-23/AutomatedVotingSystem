package im.vtngsystm.repository;

import im.vtngsystm.entity.ElectionCommissioner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionCommissionerRepository extends JpaRepository<ElectionCommissioner, String> {

    ElectionCommissioner findElectionCommissionerByName(String name);
}
