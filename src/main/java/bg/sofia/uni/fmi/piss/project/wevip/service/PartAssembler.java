package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.PartDto;
import bg.sofia.uni.fmi.piss.project.wevip.model.Part;
import org.springframework.stereotype.Component;

@Component
public class PartAssembler {
  public Part toPart(PartDto catDto) {
    Part cat = new Part();
    cat.setName(catDto.getName());
    return cat;
  }

  public PartDto toPartDto(Part cat) {
    PartDto catDto = new PartDto();
    catDto.setName(cat.getName());
    catDto.setPartId(cat.getId());
    return catDto;
  }
}
