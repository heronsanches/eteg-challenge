package com.eteg.heronsanches.eteg.jparepositiry;

import com.eteg.heronsanches.eteg.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Heron Sanches
 */
public interface PrescriptionR extends JpaRepository<Prescription, Long>{
}