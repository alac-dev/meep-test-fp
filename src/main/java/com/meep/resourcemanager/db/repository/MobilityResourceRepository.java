package com.meep.resourcemanager.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meep.resourcemanager.db.domain.MobilityResource;

/**
 * Repositorio de <MobilityResource>
 * 
 * @author fromerop90@gmail.com
 *
 */
@Repository
public interface MobilityResourceRepository extends JpaRepository<MobilityResource, String> {

}
