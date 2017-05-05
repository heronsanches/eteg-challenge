package com.eteg.heronsanches.eteg.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Heron Sanches
 */
@Entity
@Table(name = "prescription")
public class Prescription implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "id_prescription_num")
   private Long idPrescriptionNum;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "dt_register")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dtRegister;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescription")
   private Collection<PrescriptionMedication> prescriptionMedicationCollection;
   
   @JoinColumn(name = "id_patient_txt_cpf", referencedColumnName = "id_patient_txt_cpf")
   @ManyToOne(optional = false)
   private Patient idPatientTxtCpf;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "dt_last_update")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dtLastUpdate;

   
   public Prescription() {
   }

   public Prescription(Long idPrescriptionNum) {
      this.idPrescriptionNum = idPrescriptionNum;
   }

   public Prescription(Long idPrescriptionNum, Date dtRegister) {
      this.idPrescriptionNum = idPrescriptionNum;
      this.dtRegister = dtRegister;
   }

   public Long getIdPrescriptionNum() {
      return idPrescriptionNum;
   }

   public void setIdPrescriptionNum(Long idPrescriptionNum) {
      this.idPrescriptionNum = idPrescriptionNum;
   }

   public Date getDtRegister() {
      return dtRegister;
   }

   public void setDtRegister(Date dtRegister) {
      this.dtRegister = dtRegister;
   }

   public Collection<PrescriptionMedication> getPrescriptionMedicationCollection() {
      return prescriptionMedicationCollection;
   }

   public void setPrescriptionMedicationCollection(Collection<PrescriptionMedication> prescriptionMedicationCollection) {
      this.prescriptionMedicationCollection = prescriptionMedicationCollection;
   }

   public Patient getIdPatientTxtCpf() {
      return idPatientTxtCpf;
   }

   public void setIdPatientTxtCpf(Patient idPatientTxtCpf) {
      this.idPatientTxtCpf = idPatientTxtCpf;
   }

   public Date getDtLastUpdate() {
      return dtLastUpdate;
   }

   public void setDtLastUpdate(Date dtLastUpdate) {
      this.dtLastUpdate = dtLastUpdate;
   }

   
}