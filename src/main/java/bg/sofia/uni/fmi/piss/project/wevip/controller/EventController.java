package bg.sofia.uni.fmi.piss.project.wevip.controller;

import bg.sofia.uni.fmi.piss.project.wevip.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/events", produces = "application/json", consumes = "application/json")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/all")
    public ResponseEntity getEvents() {
        return eventService.getAllEvents();
    }
}
