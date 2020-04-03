package auth.jardin.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import auth.jardin.utils.FileStorageException;
import auth.jardin.utils.FileStorageProperties;

@Service
public class FileStorageService {
	
	   private final Path fileStorageLocation;

	    @Autowired
	    public FileStorageService(FileStorageProperties fileStorageProperties) {
	        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
	                .toAbsolutePath().normalize();

	        try {
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.");
	        }
	    }
	
	public String storeFile(MultipartFile file) {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        try {
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }
	            Path targetLocation = this.fileStorageLocation.resolve(fileName);
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

	            return fileName;
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
	        }
	}

	public Resource loadFileAsResource(String fileName) throws IOException {
		Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
            return resource;
		
	}

}
