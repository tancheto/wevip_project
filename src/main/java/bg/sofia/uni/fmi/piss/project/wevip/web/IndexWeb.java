package bg.sofia.uni.fmi.piss.project.wevip.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexWeb {

    @RequestMapping("/index")
    public String index(){
        System.out.println("Hi!");
        return "index.html";
    }
}
