package bg.sofia.uni.fmi.piss.project.wevip.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static bg.sofia.uni.fmi.piss.project.wevip.SecurityConstants.USER_DIR;

import java.net.Socket;
import java.util.concurrent.TimeUnit;
	
@Service
public class FileService {

    public ResponseEntity uploadFile(MultipartFile file, String username) {

		String uploadDir = USER_DIR + username;

		try {
			Path copyLocation = Paths
					.get(uploadDir + File.separator + "profile_pic.jpg");

			Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

			TimeUnit.SECONDS.sleep(1);

			if (checkFileForNudity(copyLocation.toString())) {
				// delete the nude pic
				File nudePic = new File(copyLocation.toString());
				nudePic.delete();

				return new ResponseEntity<>("You sent a picture with inappropriate content!",
						HttpStatus.FORBIDDEN);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return new ResponseEntity<>("There was an error processing your picture. Please upload it again.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Your picture is uploaded successfully!",
				HttpStatus.OK);
    }
 
	public boolean checkFileForNudity(String absolutePathToFile) {
		try {	
			Socket socket = new Socket("localhost", 5678);		
			OutputStream oos = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(oos, true);
			writer.println(absolutePathToFile);
			
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
}
