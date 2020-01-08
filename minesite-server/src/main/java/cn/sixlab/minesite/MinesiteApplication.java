package cn.sixlab.minesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MinesiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinesiteApplication.class, args);
	}

}
