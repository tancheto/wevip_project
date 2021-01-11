package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.EventDto;
import bg.sofia.uni.fmi.piss.project.wevip.model.Event;
import bg.sofia.uni.fmi.piss.project.wevip.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventAssembler eventAssembler;

    @Override
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events.stream().map(event -> eventAssembler.toEventDto(event)).sorted(Comparator
                .comparingLong(EventDto::getEventId)).collect(Collectors.toList()), HttpStatus.OK);
    }
}
