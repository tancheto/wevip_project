//package bg.sofia.uni.fmi.piss.project.wevip.controller;
//
//import bg.sofia.uni.fmi.piss.project.wevip.dto.TaskDto;
//import bg.sofia.uni.fmi.piss.project.wevip.service.TaskService;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(path = "/noSolutionTasks", produces = "application/json", consumes = "application/json")
//public class NoSolutionTaskController {
//  @Autowired
//  private TaskService taskService;
//
//
//  @GetMapping("/")
//  public ResponseEntity getTasks() {
//    return taskService.getAllTasks();
//
//  }
//
//  @PostMapping("/task")
//  public ResponseEntity<TaskDto> processGetTask(@RequestBody String line) {
//    return taskService.getOfferedTaskDetails(Long.parseLong(line.split(":", 2)[1]));
//  }
//
//  @PostMapping("/{taskId}/offer")
//  public ResponseEntity processOffer(@PathVariable Long taskId, @Valid @RequestBody TaskDto taskDto, BindingResult binding) {
//    if (binding.hasErrors()) {
//      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    return taskService.offer(taskId, taskDto);
//  }
//
//  @PostMapping("/{taskId}/approve")
//  public ResponseEntity<TaskDto> processApprove(@PathVariable Long taskId, @Valid @RequestBody TaskDto taskDto, BindingResult binding) {
//    if (binding.hasErrors()) {
//      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    return taskService.approve(taskId, taskDto);
//  }
//}
