//package bg.sofia.uni.fmi.piss.project.wevip.user;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("management/api/v1/users")
//public class UserManagementController {
//
//    private static final List<WevipUser> WEVIP_USERS = Arrays.asList(
//            new WevipUser(1, "James Bond"),
//            new WevipUser(2, "Tanya Hristova"),
//            new WevipUser(3, "Anna Smith")
//    );
//
//    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
//    public List<WevipUser> getAllUsers() {
//        System.out.println("getAllUsers");
//        return WEVIP_USERS;
//    }
//
//    @PostMapping
//    @PreAuthorize("hasAuthority('user:write')")
//    public void registerNewUser(@RequestBody WevipUser user) {
//        System.out.println("registerNewUser");
//        System.out.println(user);
//    }
//
//    @DeleteMapping(path = "{userId}")
//    @PreAuthorize("hasAuthority('user:write')")
//    public void deleteUser(@PathVariable("userId") Integer userId) {
//        System.out.println("deleteUser");
//        System.out.println(userId);
//    }
//
//    @PutMapping(path = "{userId}")
//    @PreAuthorize("hasAuthority('user:write')")
//    public void updateStudent(@PathVariable("userId") Integer userId, @RequestBody WevipUser user) {
//        System.out.println("updateStudent");
//        System.out.println(String.format("%s %s", userId, user));
//    }
//}
