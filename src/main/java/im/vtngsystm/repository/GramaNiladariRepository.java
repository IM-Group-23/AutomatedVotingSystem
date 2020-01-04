package im.vtngsystm.repository;

import im.vtngsystm.entity.GramaNiladari;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GramaNiladariRepository extends JpaRepository<GramaNiladari, String> {

    GramaNiladari findGramaNiladariByName(String name);
}
