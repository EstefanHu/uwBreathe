package edu.uw.breathe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import edu.uw.breathe.fileprocessor.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class uwBreatheApplication {

	public static void main(String[] args) {
		SpringApplication.run(uwBreatheApplication.class, args);
	}

}
