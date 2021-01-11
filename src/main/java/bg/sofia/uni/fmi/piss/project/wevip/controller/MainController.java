package bg.sofia.uni.fmi.piss.project.wevip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/index")
  String index() {
    return "index";
  }

  @GetMapping("/registrationForm")
  String registrationForm() {
    return "registrationForm";
  }

  @GetMapping("/loginForm")
  String loginForm() {
    return "loginForm";
  }

  @GetMapping("/main")
  String main() {
    return "main";
  }

  @GetMapping("/practice/{taskId}")
  String practice() {
    return "practice";
  }

  @GetMapping("/noSolutionTasks")
  String noSolutionTasks() {
    return "noSolutionTasks";
  }

  @GetMapping("/offer")
  String offer() {
    return "offer";
  }

  @GetMapping("/add")
  String add() {
    return "add";
  }

  @GetMapping("/approve")
  String approve() {
    return "approve";
  }

  @GetMapping("/events")
  String events() {
    return "events";
  }
}
