package com.eteg.heronsanches.eteg.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Heron Sanches
 */
@Entity
@Table(name = "prescription_medication")
public class PrescriptionMedication implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @EmbeddedId
   protected PrescriptionMedicationPK prescriptionMedicationPK;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "txt_frequency")
   private String txtFrequency;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "txt_dosage")
   private String txtDosage;
   
   @JoinColumn(name = "id_medication_num", referencedColumnName = "id_medication_num", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private Medication medication;
   
   @JoinColumn(name = "id_prescription_num", referencedColumnName = "id_prescription_num", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private Prescription prescription;

   
   public PrescriptionMedication() {
   }

   public PrescriptionMedication(PrescriptionMedicationPK prescriptionMedicationPK) {
      this.prescriptionMedicationPK = prescriptionMedicationPK;
   }

   public PrescriptionMedication(PrescriptionMedicationPK prescriptionMedicationPK, String txtFrequency, String txtDosage) {
      this.prescriptionMedicationPK = prescriptionMedicationPK;
      this.txtFrequency = txtFrequency;
      this.txtDosage = txtDosage;
   }

   public PrescriptionMedication(long idPrescriptionNum, long idMedicationNum) {
      this.prescriptionMedicationPK = new PrescriptionMedicationPK(idPrescriptionNum, idMedicationNum);
   }

   public PrescriptionMedicationPK getPrescriptionMedicationPK() {
      return prescriptionMedicationPK;
   }

   public void setPrescriptionMedicationPK(PrescriptionMedicationPK prescriptionMedicationPK) {
      this.prescriptionMedicationPK = prescriptionMedicationPK;
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

   public Medication getMedication() {
      return medication;
   }

   public void setMedication(Medication medication) {
      this.medication = medication;
   }

   public Prescription getPrescription() {
      return prescription;
   }

   public void setPrescription(Prescription prescription) {
      this.prescription = prescription;
   }


}