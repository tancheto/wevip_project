package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.EventDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {

    ResponseEntity<List<EventDto>> getAllEvents();

    ResponseEntity<List<EventDto>> getTop30Events();

    ResponseEntity<EventDto> getEventById(long id);
}
