package auth.jardin.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import auth.jardin.services.FileStorageService;
import auth.jardin.services.IServiceFile;
import auth.jardin.utils.CustomObjectResponse;

public class FileController {
	@Autowired
    IServiceFile fileService;
    @Autowired
    private FileStorageService fileStorageService;
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private void  upload(MultipartFile file) {
    	String fileName = fileStorageService.storeFile(file);
        ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
    }
    @PostMapping(value ="/uploadFile", consumes =  {"multipart/form-data"} )
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException  {
    	this.upload(file);
        fileService.uploadFile(file);
    	return new ResponseEntity<Object>(new CustomObjectResponse("Upload done"), HttpStatus.OK);
    }
    
    @PostMapping(value = "/uploadMultipleFile", consumes =  {"multipart/form-data"} )
    public ResponseEntity<Object> uploadFiles(@RequestParam("files") MultipartFile[] files)  {
    	 Arrays.asList(files)
                 .stream()
                 .forEach(file -> {
                 	 this.upload(file);
                     fileService.uploadFile(file);
                 	});
    	return new ResponseEntity<Object>(new CustomObjectResponse("Upload done"), HttpStatus.OK);
    }
    
    @GetMapping("/getFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok() .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

}
