//package bg.sofia.uni.fmi.piss.project.wevip.controller;
//
//import bg.sofia.uni.fmi.piss.project.wevip.dto.PartDto;
//import bg.sofia.uni.fmi.piss.project.wevip.service.PartService;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(path = "/parts", produces = "application/json", consumes = "application/json")
//public class PartController {
//  @Autowired
//  private PartService partService;
//
//  @GetMapping("/")
//  public ResponseEntity<List<PartDto>> processGetAllParts() {
//    return partService.getAllParts();
//  }
//}
