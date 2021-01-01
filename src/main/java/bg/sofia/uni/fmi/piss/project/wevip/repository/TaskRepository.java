package bg.sofia.uni.fmi.piss.project.wevip.repository;

import bg.sofia.uni.fmi.piss.project.wevip.model.Difficulty;
import bg.sofia.uni.fmi.piss.project.wevip.model.Part;
import bg.sofia.uni.fmi.piss.project.wevip.model.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByPartAndDifficulty(Part part, Difficulty difficulty);

  List<Task> findByPartIsNullAndDifficultyIsNull();

  boolean existsByTitle(String title);
}
