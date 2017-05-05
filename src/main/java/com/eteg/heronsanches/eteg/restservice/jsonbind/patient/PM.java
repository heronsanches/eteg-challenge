package com.eteg.heronsanches.eteg.restservice.jsonbind.patient;

/**
 *
 * @author Heron Sanches
 */
public class PM {

   private long idMedicationNum;
   private String txtFrequency;
   private String txtDosage;
   private String txtNameMedication;
   

   public long getIdMedicationNum() {
      return idMedicationNum;
   }

   public void setIdMedicationNum(long idMedicationNum) {
      this.idMedicationNum = idMedicationNum;
   }

   public String getTxtFrequency() {
      return txtFrequency;
   }

   public void setTxtFrequency(String txtFrequency) {
      this.txtFrequency = txtFrequency;
   }

   public String getTxtDosage() {
      return txtDosage;
   }

   public void setTxtDosage(String txtDosage) {
      this.txtDosage = txtDosage;
   }

   public String getTxtNameMedication() {
      return txtNameMedication;
   }

   public void setTxtNameMedication(String txtNameMedication) {
      this.txtNameMedication = txtNameMedication;
   }

   
}