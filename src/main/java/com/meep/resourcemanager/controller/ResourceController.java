package com.meep.resourcemanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meep.resourcemanager.db.domain.MobilityResource;
import com.meep.resourcemanager.services.ResourceService;

/**
 * Controlador de Recursos
 * 
 * @author francisco.romeroporr
 *
 */
@RestController
public class ResourceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    /**
     * Obtiene un listado de Recuros de Movildiad Guardados.
     * @return
     */
    @GetMapping(value = "/resources")
    public List<MobilityResource> getResources() {
	LOGGER.info("Consulta de Recursos de Movildiad Empieza.");
	List<MobilityResource> mobilityResources = resourceService.getSavedMobilityResources();
	LOGGER.info("Consulta de Recursos de Movildiad Termina con {} registros.", mobilityResources.size());
	return mobilityResources;
    }
}
