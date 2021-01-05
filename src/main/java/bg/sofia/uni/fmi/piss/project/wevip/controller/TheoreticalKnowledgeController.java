//package bg.sofia.uni.fmi.piss.project.wevip.controller;
//
//import bg.sofia.uni.fmi.piss.project.wevip.dto.TheoreticalKnowledgeDto;
//import bg.sofia.uni.fmi.piss.project.wevip.service.TheoreticalKnowledgeService;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(path = "/theory", produces = "application/json", consumes = "application/json")
//public class TheoreticalKnowledgeController {
//  @Autowired
//  private TheoreticalKnowledgeService theoreticalKnowledgeService;
//
//  @GetMapping("/")
//  public ResponseEntity<List<TheoreticalKnowledgeDto>> processGetAllTheory() {
//    return theoreticalKnowledgeService.getAllTheoreticalKnowledges();
//  }
//
//  @PostMapping("/task")
//  public ResponseEntity<TheoreticalKnowledgeDto> processGetTheory(@RequestBody String line) {
//    return theoreticalKnowledgeService.getTheoreticalKnowledge(Long.parseLong(line.split(":", 2)[1]));
//  }
//}
