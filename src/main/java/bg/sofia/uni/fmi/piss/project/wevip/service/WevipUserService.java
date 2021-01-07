package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.WevipUserDto;
import bg.sofia.uni.fmi.piss.project.wevip.model.WevipUser;
import bg.sofia.uni.fmi.piss.project.wevip.repository.WevipUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WevipUserService implements UserService {

    @Autowired
    private WevipUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAssembler userAssembler;

    @Override
    public ResponseEntity<WevipUserDto> register(WevipUserDto userDto) {
        WevipUser existingUser = userRepository.findByUsername(userDto.getEmail());
        if (existingUser != null) {
          return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        WevipUser user = userAssembler.toUser(userDto);
        userRepository.save(user);

        return new ResponseEntity<>(userAssembler.toUserDto(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity login(WevipUserDto userDto) {
        WevipUser user = userRepository.findByUsername(userDto.getUsername());
        if (user == null) {
          return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public WevipUser getAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userRepository.findByUsername(name);
    }
}

