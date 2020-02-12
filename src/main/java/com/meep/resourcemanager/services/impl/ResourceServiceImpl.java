package com.meep.resourcemanager.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meep.resourcemanager.db.domain.MobilityResource;
import com.meep.resourcemanager.db.repository.MobilityResourceRepository;
import com.meep.resourcemanager.services.ResourceService;
import com.meep.resourcemanager.services.exception.MobilityResourceException;

/**
 * Implementación de los servicios de Recursos de Movildiad
 * 
 * @author fromerop90@gmail.com
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${meep.wsrest.resources.url}")
    private String resourcesUrl;

    @Value("${meep.wsrest.resources.params.lowerLeftLatLon}")
    private String lowerLeftLatLonList;

    @Value("${meep.wsrest.resources.params.upperRightLatLon}")
    private String upperRightLatLonList;

    @Value("${meep.wsrest.resources.params.companyZoneIds}")
    private String companyZoneIdsList;

    @Autowired
    private MobilityResourceRepository mobilityResourceRepository;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.meep.resourcemanager.services.ResourceService#getSavedMobilityResources()
     */
    @Override
    public List<MobilityResource> getSavedMobilityResources() {
	return mobilityResourceRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.meep.resourcemanager.services.ResourceService#refreshResources()
     */
    @Override
    @Transactional
    public List<MobilityResource> refreshResources() {
	List<MobilityResource> newResources = getMobilityResourcesFromService();
	List<MobilityResource> changedResources = new ArrayList<>();
	LOGGER.info("Se guardan los Recursos de Movildiad obtenidos.");
	changedResources.addAll(mobilityResourceRepository.saveAll(newResources));
	return changedResources;
    }

    /**
     * Obtiene del servicio REST un listado de Recursos de Movilidad.
     * 
     * @return
     */
    private List<MobilityResource> getMobilityResourcesFromService() {
	LOGGER.info("Consulta de al Servicio REST de Recursos de Movildiad Empieza.");

	List<MobilityResource> listaRecursos = null;
	Pattern pattern = Pattern.compile(",");
	List<String> lowerLeftLatLon = pattern.splitAsStream(lowerLeftLatLonList).map(String::valueOf)
		.collect(Collectors.toList());
	List<String> upperRightLatLon = pattern.splitAsStream(upperRightLatLonList).map(String::valueOf)
		.collect(Collectors.toList());
	List<String> companyZoneIds = pattern.splitAsStream(companyZoneIdsList).map(String::valueOf)
		.collect(Collectors.toList());

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(resourcesUrl)
		.queryParam("lowerLeftLatLon", lowerLeftLatLon).queryParam("upperRightLatLon", upperRightLatLon)
		.queryParam("upperRightLatLon", companyZoneIds);

	HttpEntity<String> entity = new HttpEntity<>(createHeaders());

	ParameterizedTypeReference<JsonNode> responseType = new ParameterizedTypeReference<JsonNode>() {
	};
	ObjectMapper mapper = new ObjectMapper();
	ResponseEntity<JsonNode> response = null;
	try {
	    response = restTemplate.exchange(builder.build().encode().toUriString(), HttpMethod.GET, entity,
		    responseType);
	} catch (HttpServerErrorException | HttpClientErrorException | UnknownHttpStatusCodeException ex) {
	    LOGGER.debug("getMobilityResource - Exception: {}", ex.getMessage());
	    LOGGER.error("getMobilityResource - StackTrace: {}", ExceptionUtils.getStackTrace(ex));
	    throw new MobilityResourceException("No se han obtenido los registros del Servicio REST en " + resourcesUrl,
		    ex);
	} catch (Exception ex) {
	    LOGGER.debug("getMobilityResource - Exception: {}", ex.getMessage());
	    LOGGER.error("getMobilityResource - StackTrace: {}", ExceptionUtils.getStackTrace(ex));
	    throw new MobilityResourceException("Error de conexión con el Servicio REST en " + resourcesUrl, ex);
	}

	if (response.getStatusCode().equals(HttpStatus.OK)) {
	    JsonNode body = response.getBody();
	    listaRecursos = mapper.convertValue(body, new TypeReference<List<MobilityResource>>() {
	    });
	    if (listaRecursos.isEmpty()) {
		throw new MobilityResourceException("El Servicio REST no devuelve ningun registro.");
	    }
	} else {
	    throw new MobilityResourceException(
		    "No se han obtenido los registros del Servicio REST en " + resourcesUrl);
	}

	LOGGER.info("Consulta de al Servicio REST de Recursos de Movildiad Termina con {} registros.",
		listaRecursos.size());
	return listaRecursos;
    }

    /**
     * Crea las cabeceras para la llamada
     * 
     * @return
     */
    private HttpHeaders createHeaders() {
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
	return httpHeaders;
    }

}
