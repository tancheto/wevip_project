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


import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;



	
@Service
public class FileService {

    public void uploadFile(MultipartFile file, String username) {
        try {
			// Create a tmp file to validate before moving in it to the system
			File tempFile = File.createTempFile("prefix-", ".png");
			Path temp_name = Paths.get(tempFile.getAbsolutePath());

		    Files.copy(file.getInputStream(), temp_name, StandardCopyOption.REPLACE_EXISTING);	
			TimeUnit.SECONDS.sleep(1);

			if (checkFile(tempFile.getAbsolutePath())) {
				// Tanchi to decide
				return;
			}

        	String uploadDir = USER_DIR + File.separator + username;
			Path copyLocation = Paths
                    .get("/tmp" + File.separator + "profile_pic.jpg");
                    //.get(uploadDir + File.separator + "profile_pic.jpg");

			Files.move(temp_name, copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }		
    }
 
	public boolean checkFile(String temp_name) {
		try {	
			Socket socket = new Socket("localhost", 5678);		
			OutputStream oos = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(oos, true);
			writer.println(temp_name);
			
			InputStream ois = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(ois);
			int message = reader.read();

			ois.close();
			oos.close();

			return message == 1;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

//here the pic can be processed for nudity detection
//the path to the pic is {uploadDir}/profile_pic.jpg
//see above :)
}
