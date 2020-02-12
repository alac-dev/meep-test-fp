package com.meep.resourcemanager.scheduled;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.meep.resourcemanager.db.domain.MobilityResource;
import com.meep.resourcemanager.services.ResourceService;

/**
 * Planificador de tareas
 * 
 * @author fromerop90@gmail.com
 *
 */
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private ResourceService resourceService;

    /**
     * Llama repetitivamente a resourceService.refreshResources() cada 30.000
     * milisegundos (30 segundos)
     */
    @Scheduled(fixedRate = 30000)
    public void scheduleTaskRefresh() {
	LOGGER.info("Tarea programada de refresco de datos: Empieza.");
	List<MobilityResource> changedMobilityResources = resourceService.refreshResources();
	LOGGER.info("Tarea programada de refresco de datos: Termina con {} registros.",
		changedMobilityResources.size());
    }

}