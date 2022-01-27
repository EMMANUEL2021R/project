package com.efunzo.services.epellationfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EpellationfrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpellationfrontApplication.class, args);
	}

}
