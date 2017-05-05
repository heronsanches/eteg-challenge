package com.eteg.heronsanches.eteg.jparepositiry;

import com.eteg.heronsanches.eteg.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Heron Sanches
 */
public interface MedicationR extends JpaRepository<Medication, Long>{  
}