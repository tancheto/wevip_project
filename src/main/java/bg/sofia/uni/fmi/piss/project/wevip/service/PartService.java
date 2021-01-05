package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.PartDto;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface PartService {
  ResponseEntity<PartDto> getPart(Long id);

  ResponseEntity<List<PartDto>> getAllParts();
}
