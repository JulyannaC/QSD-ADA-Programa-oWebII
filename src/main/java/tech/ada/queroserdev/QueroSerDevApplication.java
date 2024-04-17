package tech.ada.queroserdev;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RequiredArgsConstructor
@EnableFeignClients
@SpringBootApplication()
public class QueroSerDevApplication {

	public static void main(String[] args) {

		SpringApplication.run(QueroSerDevApplication.class, args);
	}

}
