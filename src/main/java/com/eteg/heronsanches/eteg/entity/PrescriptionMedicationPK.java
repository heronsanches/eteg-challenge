package com.eteg.heronsanches.eteg.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Heron Sanches
 */
@Embeddable
public class PrescriptionMedicationPK implements Serializable {

   @Basic(optional = false)
   @NotNull
   @Column(name = "id_prescription_num")
   private long idPrescriptionNum;
   
   @Basic(optional = false)
   @NotNull
   @Column(name = "id_medication_num")
   private long idMedicationNum;

   
   public PrescriptionMedicationPK() {
   }

   public PrescriptionMedicationPK(long idPrescriptionNum, long idMedicationNum) {
      this.idPrescriptionNum = idPrescriptionNum;
      this.idMedicationNum = idMedicationNum;
   }

   public long getIdPrescriptionNum() {
      return idPrescriptionNum;
   }

   public void setIdPrescriptionNum(long idPrescriptionNum) {
      this.idPrescriptionNum = idPrescriptionNum;
   }

   public long getIdMedicationNum() {
      return idMedicationNum;
   }

   public void setIdMedicationNum(long idMedicationNum) {
      this.idMedicationNum = idMedicationNum;
   }


}