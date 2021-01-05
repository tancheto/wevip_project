//package bg.sofia.uni.fmi.piss.project.service;
//
//import bg.sofia.uni.fmi.piss.project.dto.PartDto;
//import bg.sofia.uni.fmi.piss.project.entity.Part;
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
//public class PartServiceImpl implements PartService {
//
//  @Autowired
//  private PartRepository partRepository;
//  @Autowired
//  private PartAssembler partAssembler;
//
//  public ResponseEntity<PartDto> getPart(Long id) {
//    Part part = partRepository.findOne(id);
//    if (part == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    return new ResponseEntity<>(partAssembler.toPartDto(part), HttpStatus.OK);
//  }
//
//  public ResponseEntity<List<PartDto>> getAllParts() {
//    List<Part> parts = partRepository.findAll();
//
//    return new ResponseEntity<>(parts.stream().map(part -> partAssembler.toPartDto(part)).sorted(Comparator
//        .comparingLong(PartDto::getPartId)).collect(Collectors.toList()), HttpStatus.OK);
//  }
//}
