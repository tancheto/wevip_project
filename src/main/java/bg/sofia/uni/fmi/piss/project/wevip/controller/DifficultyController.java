//package bg.sofia.uni.fmi.piss.project.wevip.controller;
//
//import bg.sofia.uni.fmi.piss.project.wevip.dto.DifficultyDto;
//import bg.sofia.uni.fmi.piss.project.wevip.service.DifficultyService;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(path = "/difficulties", produces = "application/json", consumes = "application/json")
//public class DifficultyController {
//  @Autowired
//  private DifficultyService difficultyService;
//
//  @PostMapping("/")
//  public ResponseEntity<List<DifficultyDto>> processGetDifficultiesByPart(@RequestBody String line) {
//    return difficultyService.getAllDifficultiesByPart(Long.parseLong(line.split(":", 2)[1]));
//  }
//}
