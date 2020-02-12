package com.meep.resourcemanager.db.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.meep.resourcemanager.db.config.TestRepositoryCfg;
import com.meep.resourcemanager.db.domain.MobilityResource;

/**
 * Test sobre <MobilityResourceRepository>
 * 
 * @author fromerop90@gmail.com
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { TestRepositoryCfg.class })
@Sql(scripts = { "classpath:db/mobility_resources-data.sql" })
public class MobilityResourceRepositoryTest {

    @Autowired
    private MobilityResourceRepository mobilityResourceRepository;

    private static final String ID = "402:11059006";
    private static final String ID_NOT_EXIST = "1234567890qwerty";
    private static final Integer NUM_ROWS = 383;

    /**
     * Prueba de obtención de todos los registros
     */
    @Test
    public void testFindAll() {
	List<MobilityResource> mobilityResources = mobilityResourceRepository.findAll();
	assertThat(mobilityResources, is(IsNull.notNullValue()));
	assertTrue(mobilityResources.size() == NUM_ROWS);
    }

    /**
     * Prueba de obtención de un registro
     */
    @Test
    public void testFindById() {
	Optional<MobilityResource> user = mobilityResourceRepository.findById(ID);
	assertTrue(user.isPresent());
    }

    /**
     * Prueba de obtención de un registro fallida
     */
    @Test
    public void testFindByIdNotFound() {
	Optional<MobilityResource> user = mobilityResourceRepository.findById(ID_NOT_EXIST);
	assertFalse(user.isPresent());
    }

}
