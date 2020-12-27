package bg.sofia.uni.fmi.piss.project.wevip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping("index")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("login")
    public String getLoginView() {
        return "login.html";
    }

    @GetMapping("events")
    public String getEvents(){
        return "events.html";
    }
}

