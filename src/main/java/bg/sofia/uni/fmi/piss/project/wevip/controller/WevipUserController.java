package bg.sofia.uni.fmi.piss.project.wevip.controller;

import bg.sofia.uni.fmi.piss.project.wevip.model.WevipUser;
import bg.sofia.uni.fmi.piss.project.wevip.repository.WevipUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class WevipUserController {

    @Autowired
    private WevipUserRepository repo;

    @GetMapping("/users")
    public List<WevipUser> getAllUsers() {
        return repo.findAll();
    }

//    @GetMapping("/users/{id}")
//    public ResponseEntity<WevipUser> getUserById (@PathVariable(value = "id") Long userId)
    //save users
    //update users
    @PostMapping("/users")
    public WevipUser createUser(@RequestBody WevipUser user) {
        return repo.save(user);
    }
    //delete users
}
