package bg.sofia.uni.fmi.piss.project.wevip.controller;

import bg.sofia.uni.fmi.piss.project.wevip.model.WevipUser;
import bg.sofia.uni.fmi.piss.project.wevip.repository.WevipUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private WevipUserRepository repo;

    @GetMapping("/index")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login.html";
    }

    @GetMapping("/events")
    public String getEvents(){
        return "events.html";
    }

    @GetMapping("/users")
    public List<WevipUser> getAllUsers() {
        return repo.findAll();
    }
}

