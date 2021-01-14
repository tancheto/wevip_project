package bg.sofia.uni.fmi.piss.project.wevip.service;

import bg.sofia.uni.fmi.piss.project.wevip.dto.WevipUserDto;
import bg.sofia.uni.fmi.piss.project.wevip.model.Event;
import bg.sofia.uni.fmi.piss.project.wevip.model.WevipUser;
import bg.sofia.uni.fmi.piss.project.wevip.repository.WevipUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static bg.sofia.uni.fmi.piss.project.wevip.jwt.SecurityConstants.USER_DIR;

@Service
public class UserServiceImpl implements UserService {

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

        try {

            Path path = Paths.get(USER_DIR + user.getUsername());
            Files.createDirectories(path);
            System.out.println("Directory is created!");

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

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
    public ResponseEntity<WevipUserDto> getAuthUser(String username) {
        WevipUser user = userRepository.findByUsername(username);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userAssembler.toUserDto(user), HttpStatus.OK);
    }
}

