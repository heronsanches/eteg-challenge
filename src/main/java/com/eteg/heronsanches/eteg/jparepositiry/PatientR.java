package com.eteg.heronsanches.eteg.jparepositiry;

import com.eteg.heronsanches.eteg.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Heron Sanches
 */
public interface PatientR extends JpaRepository<Patient, Long>{
   Patient findByIdPatientTxtCpf(String idPatientTxtCpf);
}