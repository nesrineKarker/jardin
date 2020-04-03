package auth.jardin.services;

import org.springframework.web.multipart.MultipartFile;

public interface IServiceFile {
	
	public String uploadFile(MultipartFile file);
    public String getFileName(int id);

}
