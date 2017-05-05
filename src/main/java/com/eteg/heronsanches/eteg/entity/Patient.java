package com.eteg.heronsanches.eteg.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Heron Sanches
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 11)
   @Column(name = "id_patient_txt_cpf")
   private String idPatientTxtCpf;
   
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(name = "txt_name")
   private String txtName;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "dt_birth")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dtBirth;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "dt_register")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dtRegister;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "dt_last_update")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dtLastUpdate;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatientTxtCpf")
   private Collection<Prescription> prescriptionCollection;

   
   public Patient() {
   }

   public Patient(String idPatientTxtCpf) {
      this.idPatientTxtCpf = idPatientTxtCpf;
   }

   public Patient(String idPatientTxtCpf, String txtName, Date dtBirth, Date dtRegister, Date dtLastUpdate) {
      this.idPatientTxtCpf = idPatientTxtCpf;
      this.txtName = txtName;
      this.dtBirth = dtBirth;
      this.dtRegister = dtRegister;
      this.dtLastUpdate = dtLastUpdate;
   }

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

   public Date getDtBirth() {
      return dtBirth;
   }

   public void setDtBirth(Date dtBirth) {
      this.dtBirth = dtBirth;
   }

   public Date getDtRegister() {
      return dtRegister;
   }

   public void setDtRegister(Date dtRegister) {
      this.dtRegister = dtRegister;
   }

   public Date getDtLastUpdate() {
      return dtLastUpdate;
   }

   public void setDtLastUpdate(Date dtLastUpdate) {
      this.dtLastUpdate = dtLastUpdate;
   }

   public Collection<Prescription> getPrescriptionCollection() {
      return prescriptionCollection;
   }

   public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
      this.prescriptionCollection = prescriptionCollection;
   }


}