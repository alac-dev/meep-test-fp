package com.meep.resourcemanager.cfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuración servicios REST. <blockquote> Se implementa para
 * sobreescribir la configuración de {@link RestTemplate} </blockquote>
 * 
 * @author fromerop90@gmail.com
 *
 */
@Configuration
public class RestTemplateCfg {

    private static Logger logger = LoggerFactory.getLogger(RestTemplateCfg.class);

    /**
     * Bean de configuración de Cliente Rest (RestTemplate)
     * 
     * @return {@link RestTemplate} con las configuraciones necesarias del projecto
     */
    @Bean
    public RestTemplate restTemplate() {
	logger.debug("[REST-TEMPLATE-CONF] Configurando instancia de RestTemplate");

	RestTemplate restTemplate = new RestTemplateBuilder().build();

	logger.debug("[REST-TEMPLATE-CONF] RestTemplate configurado: {}", restTemplate);

	return restTemplate;
    }
}