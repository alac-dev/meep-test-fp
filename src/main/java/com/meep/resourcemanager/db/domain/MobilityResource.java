package com.meep.resourcemanager.db.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

/**
 * Clase de la tabla mobility_resources
 * @author fromerop90@gmail.com
 *
 */
/**
 * @author fromerop90@gmail.com
 *
 */
@DynamicUpdate
@Entity(name = "mobility_resources")
public class MobilityResource implements Serializable {

    private static final long serialVersionUID = -6208057171020154534L;

    // Identificador
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private String id;

    // Nombre
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    // Coordenada X
    @NotNull
    @Column(name = "x_coordinate", nullable = false)
    private String x;

    // Coordenada Y
    @NotNull
    @Column(name = "y_coordinate", nullable = false)
    private String y;

    // Matrícula
    @Column(name = "licence_plate", nullable = true)
    private String licencePlate;

    // Rango
    @Column(name = "range", nullable = true)
    private String range;

    // Nivel de Bateria
    @Column(name = "battery_level", nullable = true)
    private String batteryLevel;

    // Cascos
    @Column(name = "helmets", nullable = true)
    private String helmets;

    // Asientos
    @Column(name = "seats", nullable = true)
    private String seats;

    // Modelo
    @Column(name = "model", nullable = true)
    private String model;

    // Identificador de la Imagen del Recurso
    @Column(name = "resource_image_id", nullable = true)
    private String resourceImageId;

    // Precio por minuto aparcado.
    @Column(name = "price_per_minute_parking", nullable = true)
    private String pricePerMinuteParking;

    // Precio por minuto conduciendo.
    @Column(name = "price_per_minute_driving", nullable = true)
    private String pricePerMinuteDriving;

    // Datos en tiempo real
    @Column(name = "real_time_data", nullable = true)
    private String realTimeData;

    // Estación
    @Column(name = "station", nullable = true)
    private String station;

    // Recursos disponibles
    @Column(name = "available_resources", nullable = true)
    private String availableResources;

    // Espacios disponibles
    @Column(name = "spaces_available", nullable = true)
    private String spacesAvailable;

    // Permitir devolución
    @Column(name = "allow_dropoff", nullable = true)
    private String allowDropoff;

    // Tipo de motor
    @Column(name = "engine_type", nullable = true)
    private String engineType;

    // Tipo de recurso
    @Column(name = "resource_type", nullable = true)
    private String resourceType;

    // Llegada Programada
    @Column(name = "scheduled_arrival", nullable = true)
    private String scheduledArrival;

    // Tipo de ubicacion
    @Column(name = "location_type", nullable = true)
    private String locationType;

    // Identificador de la Empresa de Zona
    @NotNull
    @Column(name = "company_zone_id", nullable = false)
    private String companyZoneId;

    // Bicicletas disponibles
    @Column(name = "bikes_available", nullable = true)
    private String bikesAvailable;

    // Latitud
    @Column(name = "lat", nullable = true)
    private String lat;

    // Longitud
    @Column(name = "lon", nullable = true)
    private String lon;

    /**
     * Cosntructor.
     */
    public MobilityResource() {
	super();
    }

    /**
     * @return the id
     */
    public String getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the x
     */
    public String getX() {
	return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(String x) {
	this.x = x;
    }

    /**
     * @return the y
     */
    public String getY() {
	return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(String y) {
	this.y = y;
    }

    /**
     * @return the licencePlate
     */
    public String getLicencePlate() {
	return licencePlate;
    }

    /**
     * @param licencePlate the licencePlate to set
     */
    public void setLicencePlate(String licencePlate) {
	this.licencePlate = licencePlate;
    }

    /**
     * @return the range
     */
    public String getRange() {
	return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(String range) {
	this.range = range;
    }

    /**
     * @return the batteryLevel
     */
    public String getBatteryLevel() {
	return batteryLevel;
    }

    /**
     * @param batteryLevel the batteryLevel to set
     */
    public void setBatteryLevel(String batteryLevel) {
	this.batteryLevel = batteryLevel;
    }

    /**
     * @return the helmets
     */
    public String getHelmets() {
	return helmets;
    }

    /**
     * @param helmets the helmets to set
     */
    public void setHelmets(String helmets) {
	this.helmets = helmets;
    }

    /**
     * @return the seats
     */
    public String getSeats() {
	return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(String seats) {
	this.seats = seats;
    }

    /**
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * @return the resourceImageId
     */
    public String getResourceImageId() {
	return resourceImageId;
    }

    /**
     * @param resourceImageId the resourceImageId to set
     */
    public void setResourceImageId(String resourceImageId) {
	this.resourceImageId = resourceImageId;
    }

    /**
     * @return the pricePerMinuteParking
     */
    public String getPricePerMinuteParking() {
	return pricePerMinuteParking;
    }

    /**
     * @param pricePerMinuteParking the pricePerMinuteParking to set
     */
    public void setPricePerMinuteParking(String pricePerMinuteParking) {
	this.pricePerMinuteParking = pricePerMinuteParking;
    }

    /**
     * @return the pricePerMinuteDriving
     */
    public String getPricePerMinuteDriving() {
	return pricePerMinuteDriving;
    }

    /**
     * @param pricePerMinuteDriving the pricePerMinuteDriving to set
     */
    public void setPricePerMinuteDriving(String pricePerMinuteDriving) {
	this.pricePerMinuteDriving = pricePerMinuteDriving;
    }

    /**
     * @return the realTimeData
     */
    public String getRealTimeData() {
	return realTimeData;
    }

    /**
     * @param realTimeData the realTimeData to set
     */
    public void setRealTimeData(String realTimeData) {
	this.realTimeData = realTimeData;
    }

    /**
     * @return the station
     */
    public String getStation() {
	return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(String station) {
	this.station = station;
    }

    /**
     * @return the availableResources
     */
    public String getAvailableResources() {
	return availableResources;
    }

    /**
     * @param availableResources the availableResources to set
     */
    public void setAvailableResources(String availableResources) {
	this.availableResources = availableResources;
    }

    /**
     * @return the spacesAvailable
     */
    public String getSpacesAvailable() {
	return spacesAvailable;
    }

    /**
     * @param spacesAvailable the spacesAvailable to set
     */
    public void setSpacesAvailable(String spacesAvailable) {
	this.spacesAvailable = spacesAvailable;
    }

    /**
     * @return the allowDropoff
     */
    public String getAllowDropoff() {
	return allowDropoff;
    }

    /**
     * @param allowDropoff the allowDropoff to set
     */
    public void setAllowDropoff(String allowDropoff) {
	this.allowDropoff = allowDropoff;
    }

    /**
     * @return the engineType
     */
    public String getEngineType() {
	return engineType;
    }

    /**
     * @param engineType the engineType to set
     */
    public void setEngineType(String engineType) {
	this.engineType = engineType;
    }

    /**
     * @return the resourceType
     */
    public String getResourceType() {
	return resourceType;
    }

    /**
     * @param resourceType the resourceType to set
     */
    public void setResourceType(String resourceType) {
	this.resourceType = resourceType;
    }

    /**
     * @return the scheduledArrival
     */
    public String getScheduledArrival() {
	return scheduledArrival;
    }

    /**
     * @param scheduledArrival the scheduledArrival to set
     */
    public void setScheduledArrival(String scheduledArrival) {
	this.scheduledArrival = scheduledArrival;
    }

    /**
     * @return the locationType
     */
    public String getLocationType() {
	return locationType;
    }

    /**
     * @param locationType the locationType to set
     */
    public void setLocationType(String locationType) {
	this.locationType = locationType;
    }

    /**
     * @return the companyZoneId
     */
    public String getCompanyZoneId() {
	return companyZoneId;
    }

    /**
     * @param companyZoneId the companyZoneId to set
     */
    public void setCompanyZoneId(String companyZoneId) {
	this.companyZoneId = companyZoneId;
    }

    /**
     * @return the bikesAvailable
     */
    public String getBikesAvailable() {
	return bikesAvailable;
    }

    /**
     * @param bikesAvailable the bikesAvailable to set
     */
    public void setBikesAvailable(String bikesAvailable) {
	this.bikesAvailable = bikesAvailable;
    }

    /**
     * @return the lat
     */
    public String getLat() {
	return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
	this.lat = lat;
    }

    /**
     * @return the lon
     */
    public String getLon() {
	return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(String lon) {
	this.lon = lon;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("MobilityResource [id=");
	builder.append(id);
	builder.append(", name=");
	builder.append(name);
	builder.append(", x=");
	builder.append(x);
	builder.append(", y=");
	builder.append(y);
	builder.append(", licencePlate=");
	builder.append(licencePlate);
	builder.append(", range=");
	builder.append(range);
	builder.append(", batteryLevel=");
	builder.append(batteryLevel);
	builder.append(", helmets=");
	builder.append(helmets);
	builder.append(", seats=");
	builder.append(seats);
	builder.append(", model=");
	builder.append(model);
	builder.append(", resourceImageId=");
	builder.append(resourceImageId);
	builder.append(", pricePerMinuteParking=");
	builder.append(pricePerMinuteParking);
	builder.append(", pricePerMinuteDriving=");
	builder.append(pricePerMinuteDriving);
	builder.append(", realTimeData=");
	builder.append(realTimeData);
	builder.append(", station=");
	builder.append(station);
	builder.append(", availableResources=");
	builder.append(availableResources);
	builder.append(", spacesAvailable=");
	builder.append(spacesAvailable);
	builder.append(", allowDropoff=");
	builder.append(allowDropoff);
	builder.append(", engineType=");
	builder.append(engineType);
	builder.append(", resourceType=");
	builder.append(resourceType);
	builder.append(", scheduledArrival=");
	builder.append(scheduledArrival);
	builder.append(", locationType=");
	builder.append(locationType);
	builder.append(", companyZoneId=");
	builder.append(companyZoneId);
	builder.append(", bikesAvailable=");
	builder.append(bikesAvailable);
	builder.append(", lat=");
	builder.append(lat);
	builder.append(", lon=");
	builder.append(lon);
	builder.append("]");
	return builder.toString();
    }

    public static Builder builder() {
	return new Builder();
    }

    public static class Builder {
	private String id;
	private String name;
	private String x;
	private String y;
	private String licencePlate;
	private String range;
	private String batteryLevel;
	private String helmets;
	private String seats;
	private String model;
	private String resourceImageId;
	private String pricePerMinuteParking;
	private String pricePerMinuteDriving;
	private String realTimeData;
	private String station;
	private String availableResources;
	private String spacesAvailable;
	private String allowDropoff;
	private String engineType;
	private String resourceType;
	private String scheduledArrival;
	private String locationType;
	private String companyZoneId;
	private String bikesAvailable;
	private String lat;
	private String lon;

	public Builder id(String id) {
	    this.id = id;
	    return this;
	}

	public Builder name(String name) {
	    this.name = name;
	    return this;
	}

	public Builder x(String x) {
	    this.x = x;
	    return this;
	}

	public Builder y(String y) {
	    this.y = y;
	    return this;
	}

	public Builder licencePlate(String licencePlate) {
	    this.licencePlate = licencePlate;
	    return this;
	}

	public Builder range(String range) {
	    this.range = range;
	    return this;
	}

	public Builder batteryLevel(String batteryLevel) {
	    this.batteryLevel = batteryLevel;
	    return this;
	}

	public Builder helmets(String helmets) {
	    this.helmets = helmets;
	    return this;
	}

	public Builder seats(String seats) {
	    this.seats = seats;
	    return this;
	}

	public Builder model(String model) {
	    this.model = model;
	    return this;
	}

	public Builder resourceImageId(String resourceImageId) {
	    this.resourceImageId = resourceImageId;
	    return this;
	}

	public Builder pricePerMinuteParking(String pricePerMinuteParking) {
	    this.pricePerMinuteParking = pricePerMinuteParking;
	    return this;
	}

	public Builder pricePerMinuteDriving(String pricePerMinuteDriving) {
	    this.pricePerMinuteDriving = pricePerMinuteDriving;
	    return this;
	}

	public Builder realTimeData(String realTimeData) {
	    this.realTimeData = realTimeData;
	    return this;
	}

	public Builder station(String station) {
	    this.station = station;
	    return this;
	}

	public Builder availableResources(String availableResources) {
	    this.availableResources = availableResources;
	    return this;
	}

	public Builder spacesAvailable(String spacesAvailable) {
	    this.spacesAvailable = spacesAvailable;
	    return this;
	}

	public Builder allowDropoff(String allowDropoff) {
	    this.allowDropoff = allowDropoff;
	    return this;
	}

	public Builder engineType(String engineType) {
	    this.engineType = engineType;
	    return this;
	}

	public Builder resourceType(String resourceType) {
	    this.resourceType = resourceType;
	    return this;
	}

	public Builder scheduledArrival(String scheduledArrival) {
	    this.scheduledArrival = scheduledArrival;
	    return this;
	}

	public Builder locationType(String locationType) {
	    this.locationType = locationType;
	    return this;
	}

	public Builder companyZoneId(String companyZoneId) {
	    this.companyZoneId = companyZoneId;
	    return this;
	}

	public Builder bikesAvailable(String bikesAvailable) {
	    this.bikesAvailable = bikesAvailable;
	    return this;
	}

	public Builder lat(String lat) {
	    this.lat = lat;
	    return this;
	}

	public Builder lon(String lon) {
	    this.lon = lon;
	    return this;
	}

	public MobilityResource build() {
	    return new MobilityResource(this);
	}
    }

    private MobilityResource(Builder builder) {
	this.id = builder.id;
	this.name = builder.name;
	this.x = builder.x;
	this.y = builder.y;
	this.licencePlate = builder.licencePlate;
	this.range = builder.range;
	this.batteryLevel = builder.batteryLevel;
	this.helmets = builder.helmets;
	this.seats = builder.seats;
	this.model = builder.model;
	this.resourceImageId = builder.resourceImageId;
	this.pricePerMinuteParking = builder.pricePerMinuteParking;
	this.pricePerMinuteDriving = builder.pricePerMinuteDriving;
	this.realTimeData = builder.realTimeData;
	this.station = builder.station;
	this.availableResources = builder.availableResources;
	this.spacesAvailable = builder.spacesAvailable;
	this.allowDropoff = builder.allowDropoff;
	this.engineType = builder.engineType;
	this.resourceType = builder.resourceType;
	this.scheduledArrival = builder.scheduledArrival;
	this.locationType = builder.locationType;
	this.companyZoneId = builder.companyZoneId;
	this.bikesAvailable = builder.bikesAvailable;
	this.lat = builder.lat;
	this.lon = builder.lon;
    }
}
