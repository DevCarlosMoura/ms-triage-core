package io.github.DevCarlosMoura.ms_triage_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsTriageCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTriageCoreApplication.class, args);
	}

}
