package com.eteg.heronsanches.eteg.restservice;

import com.eteg.heronsanches.eteg.entity.Patient;
import com.eteg.heronsanches.eteg.entity.Prescription;
import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.InsertPrescriptionJB;
import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.PatientJB;
import com.eteg.heronsanches.eteg.service.PatientSI;
import com.eteg.heronsanches.eteg.service.PrescriptionSI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Heron Sanches
 */
@RestController
@RequestMapping("/ws.api/health/patient")
public class PatientRS {
   
   @Autowired
   private PatientSI patientSI;
   
   @Autowired
   private PrescriptionSI prescriptionSI;
   
   
   /**@param patient: {"idPatientTxtCpf":"CPF", "txtName":"PATIENT_NAME", "dtBirth": BIRTH_DATE at milliseconds}
    * @return the {@linkplain PatientJB}*/
   @RequestMapping(method = RequestMethod.POST)
   public PatientJB insertPatient(@RequestBody Patient patient){
      return patientSI.insert(patient);
   }
   
   
   /**@param idPatientTxtCpf: CPF
    * @return {@linkplain PatientJB}*/
   @RequestMapping(method = RequestMethod.GET)
   public PatientJB getPatient(@RequestParam(value = "cpf") String idPatientTxtCpf){
      return patientSI.findByIdPatientTxtCpf(idPatientTxtCpf);
   }
   
   
   /**@param idPrescriptionNum: {@linkplain Prescription#idPrescriptionNum}
    * @return {@linkplain InsertPrescriptionJB}*/
   @RequestMapping(value = "prescription",method = RequestMethod.GET)
   public InsertPrescriptionJB getPrescription(@RequestParam(value = "idPrescription") long idPrescriptionNum){
      return prescriptionSI.get(idPrescriptionNum);
   }

   
   /**@param p: {"idPatientTxtCpf":"CPF", "prescriptionMedicationList":[{"idMedicationNum":number, "txtFrequency":"FREQUENCY", "txtDosage":"DOSAGE"}, ...]}
    * @return {@linkplain InsertPrescriptionJB}*/
   @RequestMapping(value = "prescription", method = RequestMethod.POST)
   public InsertPrescriptionJB insertPrescription(@RequestBody InsertPrescriptionJB p){
      return prescriptionSI.insert(p);
   }
   
   
   /**@param p: {"idPrescriptionNum":1, "prescriptionMedicationList":[{"idMedicationNum":number, "txtFrequency":"FREQUENCY", "txtDosage":"DOSAGE"}, ...]}
    * @return  {@linkplain InsertPrescriptionJB}*/
   @RequestMapping(value = "prescription", method = RequestMethod.PUT)
   public InsertPrescriptionJB updatePrescription(@RequestBody InsertPrescriptionJB p){
      return prescriptionSI.update(p);
   }
   
   
}