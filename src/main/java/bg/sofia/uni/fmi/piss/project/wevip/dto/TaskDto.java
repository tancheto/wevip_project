package bg.sofia.uni.fmi.piss.project.wevip.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

  private Long taskId;

  @NotNull
  private String title;

  @NotNull
  private String content;

  private String solutionValue;

  private String solutionContent;

  private Long difficultyId;

  private Long partId;

  private Long theoreticalKnowledgeId;

  public Long getTaskId() {
    return taskId;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getSolutionValue() {
    return solutionValue;
  }

  public String getSolutionContent() {
    return solutionContent;
  }

  public Long getPartId() {
    return partId;
  }

  public Long getDifficultyId() {
    return difficultyId;
  }

  public Long getTheoreticalKnowledgeId() {
    return theoreticalKnowledgeId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setSolutionContent(String solutionContent) {
    this.solutionContent = solutionContent;
  }

  public void setSolutionValue(String solutionValue) {
    this.solutionValue = solutionValue;
  }

  public void setDifficultyId(Long difficultyId) {
    this.difficultyId = difficultyId;
  }

  public void setPartId(Long partId) {
    this.partId = partId;
  }

  public void setTheoreticalKnowledgeId(Long theoreticalKnowledgeId) {
    this.theoreticalKnowledgeId = theoreticalKnowledgeId;
  }
}
