package com.eteg.heronsanches.eteg.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Heron Sanches
 */
@Entity
@Table(name = "medication")
public class Medication implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "id_medication_num")
   private Long idMedicationNum;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "txt_name")
   private String txtName;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "medication")
   private Collection<PrescriptionMedication> prescriptionMedicationCollection;

   
   public Medication(){
   }
   
   public Medication(String txtName) {
      this.txtName = txtName;
   }

   public Medication(Long idMedicationNum) {
      this.idMedicationNum = idMedicationNum;
   }

   public Medication(Long idMedicationNum, String txtName) {
      this.idMedicationNum = idMedicationNum;
      this.txtName = txtName;
   }

   public Long getIdMedicationNum() {
      return idMedicationNum;
   }

   public void setIdMedicationNum(Long idMedicationNum) {
      this.idMedicationNum = idMedicationNum;
   }

   public String getTxtName() {
      return txtName;
   }

   public void setTxtName(String txtName) {
      this.txtName = txtName;
   }

   public Collection<PrescriptionMedication> getPrescriptionMedicationCollection() {
      return prescriptionMedicationCollection;
   }

   public void setPrescriptionMedicationCollection(Collection<PrescriptionMedication> prescriptionMedicationCollection) {
      this.prescriptionMedicationCollection = prescriptionMedicationCollection;
   }


}