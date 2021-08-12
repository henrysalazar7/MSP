package com.msp.kg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MspVacunacionApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(MspVacunacionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MspVacunacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Ingresa a run commando...");
	}
}
