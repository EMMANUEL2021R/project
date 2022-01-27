package com.efunzo.services.epellation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class EpellationApplication implements CommandLineRunner{
	
	@Value("${epellation.word.per.session}")
	private int numberOfWord;

	public static void main(String[] args) {
		SpringApplication.run(EpellationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Number of word is : "+ numberOfWord);
	}

}
