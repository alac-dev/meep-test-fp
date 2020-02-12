package com.meep.resourcemanager.services.exception;

/**
 * Excepción personalizada para Recuros de Movildiad.
 * 
 * @author fromerop90@gmail.com
 *
 */
public class MobilityResourceException extends RuntimeException {

    private static final long serialVersionUID = -3645598457963675825L;

    /**
     * Constructor
     * 
     * @param message
     * @param cause
     */
    public MobilityResourceException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructor
     * 
     * @param message
     */
    public MobilityResourceException(String message) {
	super(message);
    }

}
