package bg.sofia.uni.fmi.piss.project.wevip.repository;

import bg.sofia.uni.fmi.piss.project.wevip.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
  Part findByName(String name);
}
