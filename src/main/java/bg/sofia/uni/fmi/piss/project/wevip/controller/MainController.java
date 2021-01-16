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

  @GetMapping("/users")
  String users() {
    return "users";
  }

  @GetMapping("/userProfile")
  String userProfile() {
    return "user-profile.html";
  }

  @GetMapping("/settings")
  String settings() {
    return "settings.html";
  }

  @GetMapping("/events")
  String events() {
    return "events";
  }

  @GetMapping("/events/top30")
  String eventsTop30() {
    return "eventsTop30";
  }
}
