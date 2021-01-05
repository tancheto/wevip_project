package bg.sofia.uni.fmi.piss.project.wevip.repository;

import bg.sofia.uni.fmi.piss.project.wevip.model.Difficulty;
import bg.sofia.uni.fmi.piss.project.wevip.model.Part;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
  Difficulty findByName(String name);

  List<Difficulty> findByPart(Part part);
}
