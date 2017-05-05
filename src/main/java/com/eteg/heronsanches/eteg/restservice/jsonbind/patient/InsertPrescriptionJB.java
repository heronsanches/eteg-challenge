package com.eteg.heronsanches.eteg.restservice.jsonbind.patient;

import java.util.List;

/**
 *
 * @author Heron Sanches
 */
public class InsertPrescriptionJB {
   
   private List<PM> prescriptionMedicationList;
   private String idPatientTxtCpf;
   private String txtNamePatient;
   private String dtBirthPatient;
   private String dtLastUpdatePrescription;
   private int agePatient;
   private long idPrescriptionNum;
   private String statusMessage;
   private int statusCode;
   
   
   public List<PM> getPrescriptionMedicationList() {
      return prescriptionMedicationList;
   }

   public void setPrescriptionMedicationList(List<PM> prescriptionMedicationList) {
      this.prescriptionMedicationList = prescriptionMedicationList;
   }

   public String getIdPatientTxtCpf() {
      return idPatientTxtCpf;
   }

   public void setIdPatientTxtCpf(String idPatientTxtCpf) {
      this.idPatientTxtCpf = idPatientTxtCpf;
   }

   public String getTxtNamePatient() {
      return txtNamePatient;
   }

   public void setTxtNamePatient(String txtNamePatient) {
      this.txtNamePatient = txtNamePatient;
   }

   public String getDtBirthPatient() {
      return dtBirthPatient;
   }

   public void setDtBirthPatient(String dtBirthPatient) {
      this.dtBirthPatient = dtBirthPatient;
   }

   public String getDtLastUpdatePrescription() {
      return dtLastUpdatePrescription;
   }

   public void setDtLastUpdatePrescription(String dtLastUpdatePrescription) {
      this.dtLastUpdatePrescription = dtLastUpdatePrescription;
   }

   public int getAgePatient() {
      return agePatient;
   }

   public void setAgePatient(int agePatient) {
      this.agePatient = agePatient;
   }

   public long getIdPrescriptionNum() {
      return idPrescriptionNum;
   }

   public void setIdPrescriptionNum(long idPrescriptionNum) {
      this.idPrescriptionNum = idPrescriptionNum;
   }

   public String getStatusMessage() {
      return statusMessage;
   }

   public void setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
   }

   public int getStatusCode() {
      return statusCode;
   }

   public void setStatusCode(int statusCode) {
      this.statusCode = statusCode;
   }
   
  
}