package com.meep.resourcemanager.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meep.resourcemanager.db.config.TestRepositoryCfg;
import com.meep.resourcemanager.db.domain.MobilityResource;
import com.meep.resourcemanager.db.repository.MobilityResourceRepository;
import com.meep.resourcemanager.services.impl.ResourceServiceImpl;

/**
 * Test sobre <ResourceServiceImpl>
 * 
 * @author fromerop90@gmail.com
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { TestRepositoryCfg.class })
@Sql(scripts = { "classpath:db/mobility_resources-data.sql" })
public class ResourceServiceTest {

    private static final String RESOURCES_URL = "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources";
    private static final String LOWER_LEFT_LAT_LON = "38.711046,-9.160096";
    private static final String UPPER_RIGHT_LAT_LON = "38.739429,-9.137115";
    private static final String COMPANY_ZONE_IDS = "545,467,473";
    private static final Integer NUM_ROWS = 383;

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private MobilityResourceRepository mobilityResourceRepository;

    private ResourceService service;

    @Before
    public void init() {
	initMocks(this);

	service = new ResourceServiceImpl();

	ReflectionTestUtils.setField(service, "mobilityResourceRepository", mobilityResourceRepository);
	ReflectionTestUtils.setField(service, "restTemplate", restTemplate);
	ReflectionTestUtils.setField(service, "resourcesUrl", RESOURCES_URL);
	ReflectionTestUtils.setField(service, "lowerLeftLatLonList", LOWER_LEFT_LAT_LON);
	ReflectionTestUtils.setField(service, "upperRightLatLonList", UPPER_RIGHT_LAT_LON);
	ReflectionTestUtils.setField(service, "companyZoneIdsList", COMPANY_ZONE_IDS);
    }

    @Test
    public void getGroupsTest() {
	List<MobilityResource> lista = service.getSavedMobilityResources();
	assertThat(lista, is(IsNull.notNullValue()));
	assertTrue(lista.size() == NUM_ROWS);
    }

    @Test
    public void getProductTestOK() throws RestClientException, JsonProcessingException {
	Mockito.when(restTemplate.exchange(Mockito.<String>any(), Mockito.eq(HttpMethod.GET),
		Mockito.<HttpEntity<String>>any(), Mockito.<ParameterizedTypeReference<JsonNode>>any()))
		.thenReturn(new ResponseEntity<>(getResponseJsonNode(), HttpStatus.OK));

	List<MobilityResource> response = service.refreshResources();

	Mockito.verify(restTemplate, Mockito.times(1)).exchange(Mockito.<String>any(), Mockito.eq(HttpMethod.GET),
		Mockito.<HttpEntity<String>>any(), Mockito.<ParameterizedTypeReference<JsonNode>>any());

	assertNotNull(response);
	assertTrue(response.size() > 0);
    }

    private JsonNode getResponseJsonNode() throws JsonProcessingException {
	ObjectMapper mapper = new ObjectMapper();
	String json = mapper.writeValueAsString(getListMobilityResources());
	JsonNode jsonNode = mapper.readTree(json);
	return jsonNode;
    }

    private List<MobilityResource> getListMobilityResources() {
	List<MobilityResource> lista = new ArrayList<MobilityResource>();
	lista.add(MobilityResource.builder().id("402:11059006").name("Rossio").x("-9.1424").y("38.71497")
		.scheduledArrival("0").locationType("0").companyZoneId("402").lat("38.71497").lon("-9.1424").build());

	lista.add(MobilityResource.builder().id("378:M28").name("ROSSIO").x("-9.13796").y("38.71402")
		.scheduledArrival("0").locationType("0").companyZoneId("378").lat("38.71402").lon("-9.13796").build());

	lista.add(MobilityResource.builder().id("378:M08").name("SÃO SEBASTIÃO").x("-9.15365").y("38.734")
		.scheduledArrival("0").locationType("0").companyZoneId("378").lat("38.734").lon("-9.15365").build());

	lista.add(MobilityResource.builder().id("378:M07").name("PRAÇA DE ESPANHA").x("-9.15936").y("38.7377")
		.scheduledArrival("0").locationType("0").companyZoneId("378").lat("38.7377").lon("-9.15936").build());

	lista.add(MobilityResource.builder().id("378:M09").name("PARQUE").x("-9.15015").y("38.72914")
		.scheduledArrival("0").locationType("0").companyZoneId("378").lat("38.72914").lon("-9.15015").build());

	return lista;
    }
}
