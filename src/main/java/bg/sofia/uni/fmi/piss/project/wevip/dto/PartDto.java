package bg.sofia.uni.fmi.piss.project.wevip.dto;

import javax.validation.constraints.NotNull;

public class PartDto {
  private Long partId;

  @NotNull
  private String name;

  public Long getPartId() {
    return partId;
  }

  public void setPartId(Long partId) {
    this.partId = partId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
