package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.TheoreticalKnowledgeDto;
import bg.sofia.uni.fmi.piss.project.wevip.model.TheoreticalKnowledge;
import org.springframework.stereotype.Component;

@Component
public class TheoreticalKnowledgeAssembler {
  public TheoreticalKnowledge toTheoreticalKnowledge(TheoreticalKnowledgeDto catDto) {
    TheoreticalKnowledge cat = new TheoreticalKnowledge();
    cat.setName(catDto.getName());
    return cat;
  }

  public TheoreticalKnowledgeDto toTheoreticalKnowledgeDto(TheoreticalKnowledge cat) {
    TheoreticalKnowledgeDto catDto = new TheoreticalKnowledgeDto();
    catDto.setName(cat.getName());
    catDto.setTheoreticalKnowledgeId(cat.getId());
    return catDto;
  }
}
