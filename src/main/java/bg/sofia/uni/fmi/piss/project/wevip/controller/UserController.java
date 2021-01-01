package bg.sofia.uni.fmi.piss.project.wevip.controller;

import bg.sofia.uni.fmi.piss.project.wevip.dto.WevipUserDto;

import javax.validation.Valid;

import bg.sofia.uni.fmi.piss.project.wevip.service.WevipUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user", produces = "application/json", consumes = "application/json")
public class UserController {

  @Autowired
  private WevipUserService userService;

  @PostMapping("/registrationForm")
  public ResponseEntity<WevipUserDto> processRegisterUser(@Valid @RequestBody WevipUserDto userDto, BindingResult binding) {
    if (binding.hasErrors()) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    return userService.register(userDto);
  }

  @PostMapping("/loginForm")
  public ResponseEntity processLoginUser(@Valid @RequestBody WevipUserDto userDto, BindingResult binding) {
    if (binding.hasErrors()) {
      return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    return userService.login(userDto);
  }
}
