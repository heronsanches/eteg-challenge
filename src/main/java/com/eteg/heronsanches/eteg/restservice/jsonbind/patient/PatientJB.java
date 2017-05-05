package com.eteg.heronsanches.eteg.restservice.jsonbind.patient;

/**
 *
 * @author Heron Sanches
 */
public class PatientJB {
   
   private String idPatientTxtCpf;
   private String txtName;
   private String dtBirth;
   private String dtRegister;
   private String dtLastUpdate;
   private int age;
   private String statusMessage;
   private int statusCode;

   
   public String getIdPatientTxtCpf() {
      return idPatientTxtCpf;
   }

   public void setIdPatientTxtCpf(String idPatientTxtCpf) {
      this.idPatientTxtCpf = idPatientTxtCpf;
   }

   public String getTxtName() {
      return txtName;
   }

   public void setTxtName(String txtName) {
      this.txtName = txtName;
   }

   public String getDtBirth() {
      return dtBirth;
   }

   public void setDtBirth(String dtBirth) {
      this.dtBirth = dtBirth;
   }

   public String getDtRegister() {
      return dtRegister;
   }

   public void setDtRegister(String dtRegister) {
      this.dtRegister = dtRegister;
   }

   public String getDtLastUpdate() {
      return dtLastUpdate;
   }

   public void setDtLastUpdate(String dtLastUpdate) {
      this.dtLastUpdate = dtLastUpdate;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getStatusMessage() {
      return statusMessage;
   }

   public void setStatusMessage(String status) {
      this.statusMessage = status;
   }

   public int getStatusCode() {
      return statusCode;
   }

   public void setStatusCode(int statusCode) {
      this.statusCode = statusCode;
   }
   
   
}