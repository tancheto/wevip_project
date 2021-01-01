//package bg.sofia.uni.fmi.piss.project.wevip.user;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/users")
//public class WevipUserController {
//
//    private static final List<WevipUser> WEVIP_USERS = Arrays.asList(
//            new WevipUser(1, "James Bond"),
//            new WevipUser(2, "Tanya Hristova"),
//            new WevipUser(3, "Anna Smith")
//    );
//
//    @GetMapping(path = "{userId}")
//    public WevipUser getUser(@PathVariable("userId") Integer userId) {
//        return WEVIP_USERS.stream()
//                .filter(wevipUser -> userId.equals(wevipUser.getUserId()))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("User" + userId + " does not exists."));
//    }
//}
