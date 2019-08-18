package edu.uw.info360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import edu.uw.info360.fileprocessor.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class Info360projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Info360projectApplication.class, args);
	}

}
