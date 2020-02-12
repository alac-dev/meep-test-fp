package com.meep.resourcemanager;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Clase principal del proyecto.
 * 
 * @author fromerop90@gmail.com
 *
 */
@EnableScheduling
@SpringBootApplication
public class ResourcemanagerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourcemanagerApplication.class);

    public static void main(String[] args) throws UnknownHostException {
	SpringApplication app = new SpringApplication(ResourcemanagerApplication.class);

	ConfigurableApplicationContext context = app.run(args);
	Environment env = context.getEnvironment();
	LOGGER.info("\n----------------------------------------------------------\n\t"
		+ "La aplicación '{}' está ejecutándose! URLs de acceso:\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
		+ "External: \thttp://{}:{}\n----------------------------------------------------------",
		env.getProperty("spring.application.name"), env.getProperty("server.port"),
		InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));
    }

}