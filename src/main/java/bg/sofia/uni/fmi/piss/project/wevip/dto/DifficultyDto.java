package bg.sofia.uni.fmi.piss.project.wevip.dto;

import javax.validation.constraints.NotNull;

public class DifficultyDto {
  private Long difficultyId;

  @NotNull
  private String name;

  public Long getDifficultyId() {
    return difficultyId;
  }

  public void setDifficultyId(Long difficultyId) {
    this.difficultyId = difficultyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
