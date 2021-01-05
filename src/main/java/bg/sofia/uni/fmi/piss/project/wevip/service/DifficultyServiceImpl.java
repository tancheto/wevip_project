//package bg.sofia.uni.fmi.piss.project.service;
//
//import bg.sofia.uni.fmi.piss.project.dto.DifficultyDto;
//import bg.sofia.uni.fmi.piss.project.entity.Difficulty;
//import bg.sofia.uni.fmi.piss.project.entity.Part;
//import bg.sofia.uni.fmi.piss.project.repository.DifficultyRepository;
//import bg.sofia.uni.fmi.piss.project.repository.PartRepository;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DifficultyServiceImpl implements DifficultyService {
//
//  @Autowired
//  private DifficultyRepository difficultyRepository;
//  @Autowired
//  private PartRepository partRepository;
//  @Autowired
//  private DifficultyAssembler difficultyAssembler;
//
//  public ResponseEntity<DifficultyDto> getDifficulty(Long id) {
//    Difficulty part = difficultyRepository.findOne(id);
//    if (part == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    return new ResponseEntity<>(difficultyAssembler.toDifficultyDto(part), HttpStatus.OK);
//  }
//
//  public ResponseEntity<List<DifficultyDto>> getAllDifficultiesByPart(Long partId) {
//    Part part = partRepository.findOne(partId);
//    List<Difficulty> difficulties = difficultyRepository.findByPart(part);
//
//    return new ResponseEntity<>(difficulties.stream().map(difficulty -> difficultyAssembler.toDifficultyDto(difficulty)).sorted(Comparator
//        .comparingLong(DifficultyDto::getDifficultyId)).collect(Collectors.toList()), HttpStatus.OK);
//  }
//}
