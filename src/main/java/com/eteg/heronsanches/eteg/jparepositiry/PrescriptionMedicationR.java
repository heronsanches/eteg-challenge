package com.eteg.heronsanches.eteg.jparepositiry;

import com.eteg.heronsanches.eteg.entity.PrescriptionMedication;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Heron Sanches
 */
public interface PrescriptionMedicationR extends JpaRepository<PrescriptionMedication, Long>{

   @Transactional
   @Modifying
   @Query("delete from PrescriptionMedication pm where pm.prescriptionMedicationPK.idPrescriptionNum = ?1")
   void deleteByIdPrescription(long idPrescriptionNum);

}