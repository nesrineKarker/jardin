package auth.jardin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileService")
public class FileService implements IServiceFile{
	
	@Autowired
	private FileStorageService fileStorageService;

    @Override
    public String uploadFile(MultipartFile file) {
          return fileStorageService.storeFile(file);
    }

	@Override
	public String getFileName(int id) {
		// TODO Auto-generated method stub
		return null;
	}
  

}
