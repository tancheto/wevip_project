package bg.sofia.uni.fmi.piss.project.wevip.controller;

import bg.sofia.uni.fmi.piss.project.wevip.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("img") MultipartFile file,
                                     @RequestParam("username") String username) {

        return fileService.uploadFile(file, username);
    }
}