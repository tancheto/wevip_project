package bg.sofia.uni.fmi.piss.project.wevip.repository;

import bg.sofia.uni.fmi.piss.project.wevip.model.TheoreticalKnowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoreticalKnowledgeRepository extends JpaRepository<TheoreticalKnowledge, Long> {
  TheoreticalKnowledge findByName(String name);
}
