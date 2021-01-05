package bg.sofia.uni.fmi.piss.project.wevip.dto;

import javax.validation.constraints.NotNull;

public class TheoreticalKnowledgeDto {
  private Long theoreticalKnowledgeId;

  @NotNull
  private String name;

  public Long getTheoreticalKnowledgeId() {
    return theoreticalKnowledgeId;
  }

  public void setTheoreticalKnowledgeId(Long theoreticalKnowledgeId) {
    this.theoreticalKnowledgeId = theoreticalKnowledgeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
