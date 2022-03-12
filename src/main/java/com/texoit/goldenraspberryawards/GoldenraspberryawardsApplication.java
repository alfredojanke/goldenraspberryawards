package com.texoit.goldenraspberryawards;

import com.texoit.goldenraspberryawards.indicadosvencedores.service.MovieCsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoldenraspberryawardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldenraspberryawardsApplication.class, args);
	}

}
