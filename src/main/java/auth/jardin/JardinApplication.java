package auth.jardin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import auth.jardin.utils.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class JardinApplication {

	public static void main(String[] args) {
		SpringApplication.run(JardinApplication.class, args);
	}

}
