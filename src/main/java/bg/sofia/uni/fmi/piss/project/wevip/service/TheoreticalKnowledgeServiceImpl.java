//package bg.sofia.uni.fmi.piss.project.service;
//
//import bg.sofia.uni.fmi.piss.project.dto.TheoreticalKnowledgeDto;
//import bg.sofia.uni.fmi.piss.project.entity.TheoreticalKnowledge;
//import bg.sofia.uni.fmi.piss.project.repository.TheoreticalKnowledgeRepository;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TheoreticalKnowledgeServiceImpl implements TheoreticalKnowledgeService {
//
//  @Autowired
//  private TheoreticalKnowledgeRepository theoreticalKnowledgeRepository;
//  @Autowired
//  private TheoreticalKnowledgeAssembler theoreticalKnowledgeAssembler;
//
//  public ResponseEntity<TheoreticalKnowledgeDto> getTheoreticalKnowledge(Long id) {
//    TheoreticalKnowledge part = theoreticalKnowledgeRepository.findOne(id);
//    if (part == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    return new ResponseEntity<>(theoreticalKnowledgeAssembler.toTheoreticalKnowledgeDto(part), HttpStatus.OK);
//  }
//
//  public ResponseEntity<List<TheoreticalKnowledgeDto>> getAllTheoreticalKnowledges() {
//    List<TheoreticalKnowledge> theory = theoreticalKnowledgeRepository.findAll();
//
//    return new ResponseEntity<>(theory.stream().map(theoreticalKnowledge -> theoreticalKnowledgeAssembler.toTheoreticalKnowledgeDto(theoreticalKnowledge))
//        .sorted(Comparator.comparingLong(TheoreticalKnowledgeDto::getTheoreticalKnowledgeId)).collect(Collectors.toList()), HttpStatus.OK);
//  }
//}
