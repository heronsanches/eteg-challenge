package com.eteg.heronsanches.eteg.service;

import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.InsertPrescriptionJB;

/**
 *
 * @author Heron Sanches
 */
public interface PrescriptionSI {
   
   InsertPrescriptionJB insert(InsertPrescriptionJB p);
   InsertPrescriptionJB get(long idPrescriptionNum);
   InsertPrescriptionJB update(InsertPrescriptionJB up);
   
}