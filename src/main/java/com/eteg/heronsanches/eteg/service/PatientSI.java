package com.eteg.heronsanches.eteg.service;

import com.eteg.heronsanches.eteg.entity.Patient;
import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.PatientJB;

/**
 *
 * @author Heron Sanches
 */
public interface PatientSI {
   
   PatientJB findByIdPatientTxtCpf(String idPatientTxtCpf);
   PatientJB insert(Patient patient);
   
}