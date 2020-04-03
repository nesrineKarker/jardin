package auth.jardin.utils;

import org.springframework.http.HttpStatus;

public class FileError {
	
	private HttpStatus status;
	   private String message;

	   private FileError() {
	   }

	   public FileError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   public FileError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	   }

	   public FileError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	   
}
