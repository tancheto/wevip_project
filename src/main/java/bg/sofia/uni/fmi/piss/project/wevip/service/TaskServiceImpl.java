//package bg.sofia.uni.fmi.piss.project.service;
//
//import bg.sofia.uni.fmi.piss.project.dto.TaskDto;
//import bg.sofia.uni.fmi.piss.project.entity.Difficulty;
//import bg.sofia.uni.fmi.piss.project.entity.Part;
//import bg.sofia.uni.fmi.piss.project.entity.Task;
//import bg.sofia.uni.fmi.piss.project.entity.TheoreticalKnowledge;
//import bg.sofia.uni.fmi.piss.project.repository.DifficultyRepository;
//import bg.sofia.uni.fmi.piss.project.repository.PartRepository;
//import bg.sofia.uni.fmi.piss.project.repository.TaskRepository;
//import bg.sofia.uni.fmi.piss.project.repository.TheoreticalKnowledgeRepository;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//
//import static org.apache.commons.lang3.StringUtils.isBlank;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//
//  @Autowired
//  private DifficultyRepository difficultyRepository;
//
//  @Autowired
//  private PartRepository partRepository;
//
//  @Autowired
//  private TheoreticalKnowledgeRepository theoreticalKnowledgeRepository;
//
//  @Autowired
//  private TaskRepository taskRepository;
//
//  @Autowired
//  private TaskAssembler taskAssembler;
//
//  private List<Task> offeredTasks = new ArrayList<>();
//
//  @Override
//  public ResponseEntity<TaskDto> getDetails(Long id) {
//    Task task = taskRepository.findOne(id);
//    if (task == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    return new ResponseEntity<>(taskAssembler.toTaskDto(task), HttpStatus.OK);
//  }
//
//  @Override
//  public ResponseEntity<TaskDto> getOfferedTaskDetails(Long id) {
//    return offeredTasks.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
//        : new ResponseEntity<>(taskAssembler.toTaskDto(offeredTasks.stream().filter(task -> task.getId() == id).findFirst().get()),
//        HttpStatus.OK);
//  }
//
//  @Override
//  public ResponseEntity<List<TaskDto>> getAllTasksByPartAndDifficulty(Long partId, Long difficultyId) {
//    Difficulty difficulty = difficultyRepository.findOne(difficultyId);
//    Part part = partRepository.findOne(partId);
//
//    if (difficulty == null || part == null) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    List<Task> tasks = taskRepository.findByPartAndDifficulty(part, difficulty);
//    if (tasks.isEmpty()) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    return new ResponseEntity<>(tasks.stream().map(task -> taskAssembler.toTaskDto(task)).sorted(Comparator
//        .comparingLong(TaskDto::getTaskId)).collect(Collectors.toList()), HttpStatus.OK);
//  }
//
//  @Override
//  public ResponseEntity<List<TaskDto>> getAllTasks() {
//    List<Task> tasks = taskRepository.findByPartIsNullAndDifficultyIsNull();
//    if (tasks.isEmpty()) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    return new ResponseEntity<>(tasks.stream().map(task -> taskAssembler.toTaskDto(task)).sorted(Comparator
//        .comparingLong(TaskDto::getTaskId)).collect(Collectors.toList()), HttpStatus.OK);
//  }
//
//  @Override
//  public ResponseEntity<TaskDto> add(TaskDto taskDto) {
//    String title = taskDto.getTitle();
//    Part part = partRepository.findOne(taskDto.getPartId());
//    Long difficultyId = (taskDto.getPartId() == 0 ? 0 : (taskDto.getPartId() - 1) * 5 + taskDto.getDifficultyId());
//    Difficulty difficulty = difficultyRepository.findOne(difficultyId);
//
//    if (taskRepository.existsByTitle(title)) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    Task task = new Task(title, taskDto.getContent(), taskDto.getSolutionValue(), taskDto.getSolutionContent(),
//        difficulty, part, theoreticalKnowledgeRepository.findOne(taskDto.getTheoreticalKnowledgeId()));
//
//    save(task);
//
//    return new ResponseEntity<>(taskAssembler.toTaskDto(task), HttpStatus.CREATED);
//  }
//
//  @Override
//  public ResponseEntity<TaskDto> update(Long id, TaskDto taskDto) {
//    Task task = taskRepository.findOne(id);
//    if (task == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    String title = taskDto.getTitle();
//    if (isBlank(title)) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    task.setContent(taskDto.getContent());
//    task.setSolutionValue(taskDto.getSolutionValue());
//    task.setSolutionContent(taskDto.getSolutionContent());
//    task.setTheoreticalKnowledge(theoreticalKnowledgeRepository.findOne(taskDto.getTheoreticalKnowledgeId()));
//
//    save(task);
//
//    return new ResponseEntity<>(taskAssembler.toTaskDto(task), HttpStatus.OK);
//  }
//
//  @Override
//  public ResponseEntity<Void> delete(Long id) {
//    Task task = taskRepository.findOne(id);
//    if (task == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    taskRepository.delete(task);
//    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//  }
//
//  @Override
//  public ResponseEntity<Void> offer(Long id, TaskDto taskDto) {
//    TheoreticalKnowledge theoreticalKnowledge = theoreticalKnowledgeRepository.findOne(taskDto.getTheoreticalKnowledgeId());
//    if (isBlank(taskDto.getSolutionValue()) || isBlank(taskDto.getSolutionContent()) || theoreticalKnowledge == null) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//
//    Task offeredTask = new Task(taskDto.getTitle(), taskDto.getContent(), taskDto.getSolutionValue(), taskDto.getSolutionContent(),
//        null, null, theoreticalKnowledge);
//    offeredTasks.add(offeredTask);
//    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//  }
//
//  @Override
//  public ResponseEntity<TaskDto> approve(Long id, TaskDto taskDto) {
//    String title = taskDto.getTitle();
//    Difficulty difficulty = difficultyRepository.findOne(taskDto.getDifficultyId());
//    Part part = partRepository.findOne(taskDto.getPartId());
//
//    if (taskRepository.existsByTitle(title)) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    Task task = new Task(title, taskDto.getContent(), taskDto.getSolutionValue(), taskDto.getSolutionContent(),
//        difficulty, part, theoreticalKnowledgeRepository.findOne(taskDto.getTheoreticalKnowledgeId()));
//
//    save(task);
//    offeredTasks.remove(task);
//
//    return new ResponseEntity<>(taskAssembler.toTaskDto(task), HttpStatus.CREATED);
//  }
//
//
//  private ResponseEntity<TaskDto> save(Task task) {
//    if (task.getTitle() == null || task.getContent() == null) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//    return new ResponseEntity<>(taskAssembler.toTaskDto(taskRepository.save(task)), HttpStatus.OK);
//  }
//
//}
