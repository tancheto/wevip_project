//package bg.sofia.uni.fmi.piss.project.wevip.controller;
//
//import bg.sofia.uni.fmi.piss.project.wevip.dto.TaskDto;
//import bg.sofia.uni.fmi.piss.project.wevip.dto.TaskSpecifier;
//import bg.sofia.uni.fmi.piss.project.wevip.service.TaskService;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(path = "/tasks", produces = "application/json", consumes = "application/json")
//public class TaskController {
//  @Autowired
//  private TaskService taskService;
//
//
//  @PostMapping("/")
//  public ResponseEntity getTasks(@RequestBody TaskSpecifier taskSpecifier) {
//    return taskService.getAllTasksByPartAndDifficulty((Long.parseLong(taskSpecifier.getPart())) % 5, Long.parseLong(taskSpecifier.getDifficulty()));
//
//  }
//
//  @PostMapping("/task")
//  public ResponseEntity<TaskDto> processGetTask(@RequestBody String line) {
//    return taskService.getDetails(Long.parseLong(line.split(":", 2)[1]));
//  }
//
//  @PostMapping("/add")
//  public ResponseEntity<TaskDto> processAddTask(@Valid @RequestBody TaskDto taskDto, BindingResult binding) {
//    if (binding.hasErrors()) {
//      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    return taskService.add(taskDto);
//  }
//
//  @PostMapping("/{taskId}/update")
//  public ResponseEntity<TaskDto> processUpdateTask(@PathVariable Long taskId, @Valid @RequestBody TaskDto taskDto, BindingResult binding) {
//    if (binding.hasErrors()) {
//      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    return taskService.update(taskId, taskDto);
//  }
//
//  @DeleteMapping(value = "/{taskId}")
//  public ResponseEntity<Void> processDeleteTask(@PathVariable Long taskId) {
//    return taskService.delete(taskId);
//  }
//}
