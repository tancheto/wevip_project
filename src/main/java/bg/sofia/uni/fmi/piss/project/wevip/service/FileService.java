package bg.sofia.uni.fmi.piss.project.wevip.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static bg.sofia.uni.fmi.piss.project.wevip.SecurityConstants.USER_DIR;

@Service
public class FileService {

    public void uploadFile(MultipartFile file, String username) {

        String uploadDir = USER_DIR + username;

        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + "profile_pic.jpg");

            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}