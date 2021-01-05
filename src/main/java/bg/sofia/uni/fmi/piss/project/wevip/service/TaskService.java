package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.TaskDto;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TaskService {
  ResponseEntity<TaskDto> getDetails(Long id);

  ResponseEntity<TaskDto> getOfferedTaskDetails(Long id);

  ResponseEntity<List<TaskDto>> getAllTasksByPartAndDifficulty(Long partId, Long difficultyId);

  ResponseEntity<List<TaskDto>> getAllTasks();

  ResponseEntity<TaskDto> add(TaskDto taskDto);

  ResponseEntity<TaskDto> update(Long id, TaskDto taskDto);

  ResponseEntity<Void> delete(Long id);

  ResponseEntity<Void> offer(Long id, TaskDto taskDto);

  ResponseEntity<TaskDto> approve(Long id, TaskDto taskDto);
}
