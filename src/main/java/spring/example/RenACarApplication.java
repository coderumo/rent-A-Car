package spring.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RenACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenACarApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {//modelMapper nesnesini IOC ye eklemesi için
		return new ModelMapper();
	}

}

//brand -- marka
//car--araba