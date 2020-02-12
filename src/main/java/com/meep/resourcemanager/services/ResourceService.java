package com.meep.resourcemanager.services;

import java.util.List;

import com.meep.resourcemanager.db.domain.MobilityResource;

/**
 * Interfaz de los servicios de Recursos de Movildiad
 * 
 * @author fromerop90@gmail.com
 *
 */
public interface ResourceService {

    /**
     * Obtiene todos los Recursos de Movildiad que hay guardados en la Base de
     * Datos.
     * 
     * @return
     */
    List<MobilityResource> getSavedMobilityResources();

    /**
     * Refresca los recuros que hay en la Base de Datos llamando el Servicio Rest
     * del proveedor.
     * 
     * @return
     */
    List<MobilityResource> refreshResources();
}
