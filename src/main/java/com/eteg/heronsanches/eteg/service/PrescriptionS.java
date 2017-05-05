package com.eteg.heronsanches.eteg.service;

import com.eteg.heronsanches.eteg.entity.Medication;
import com.eteg.heronsanches.eteg.entity.Patient;
import com.eteg.heronsanches.eteg.entity.Prescription;
import com.eteg.heronsanches.eteg.entity.PrescriptionMedication;
import com.eteg.heronsanches.eteg.entity.PrescriptionMedicationPK;
import com.eteg.heronsanches.eteg.jparepositiry.MedicationR;
import com.eteg.heronsanches.eteg.jparepositiry.PatientR;
import com.eteg.heronsanches.eteg.jparepositiry.PrescriptionMedicationR;
import com.eteg.heronsanches.eteg.jparepositiry.PrescriptionR;
import com.eteg.heronsanches.eteg.restservice.enums.ReturnMessageEnum;
import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.InsertPrescriptionJB;
import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.PM;
import com.eteg.heronsanches.eteg.utils.math.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Heron Sanches
 */
@Service("prescriptionS")
public class PrescriptionS implements PrescriptionSI{
   
   @Autowired
   private PrescriptionR prescriptionR;
   
   @Autowired
   private MedicationR medicationR;
   
   @Autowired
   private PatientR patientR;
   
   @Autowired
   private PrescriptionMedicationR prescriptionMedicationR;
   

   @Override
   @Transactional(rollbackForClassName={"Exception"})
   public InsertPrescriptionJB insert(InsertPrescriptionJB ip) {
      
      Date d = new Date(System.currentTimeMillis());
      Prescription presc = new Prescription();
      presc.setDtLastUpdate(d);
      presc.setDtRegister(d);
      Patient pat = patientR.findByIdPatientTxtCpf(ip.getIdPatientTxtCpf());
      presc.setIdPatientTxtCpf(pat);
      presc = prescriptionR.save(presc);
      
      List<PrescriptionMedication> lpm = new ArrayList<>();
      Map<Long, PM> mapPM = new HashMap<>();
      
      for(PM pm : ip.getPrescriptionMedicationList()){
         
         lpm.add(new PrescriptionMedication(new PrescriptionMedicationPK(presc.getIdPrescriptionNum(), pm.getIdMedicationNum()),
            pm.getTxtFrequency(), pm.getTxtDosage()));
         
         mapPM.put(pm.getIdMedicationNum(), pm);
         
      }
      
      presc.setPrescriptionMedicationCollection(lpm);
      presc = prescriptionR.save(presc);
      
      ip.setPrescriptionMedicationList(null);
      ip.setIdPrescriptionNum(presc.getIdPrescriptionNum());
      ip.setTxtNamePatient(pat.getTxtName());
      ip.setDtBirthPatient(DateUtils.SDF_WITHOUT_HOUR.format(pat.getDtBirth()));
      ip.setDtLastUpdatePrescription(DateUtils.SDF_WITH_HOUR.format(presc.getDtLastUpdate()));      
      ip.setAgePatient(DateUtils.calcAge(pat.getDtBirth().getTime()));
      
      for(PrescriptionMedication pme : presc.getPrescriptionMedicationCollection())
         mapPM.get(pme.getPrescriptionMedicationPK().getIdMedicationNum()).setTxtNameMedication(medicationR.getOne(pme.getPrescriptionMedicationPK().getIdMedicationNum()).getTxtName());
    
      ip.setPrescriptionMedicationList(new ArrayList<>(mapPM.values()));
      ip.setStatusMessage(ReturnMessageEnum.OK.getName());
      ip.setStatusCode(ReturnMessageEnum.OK.ordinal());
      return ip;

   }

   
   @Override
   @Transactional(rollbackForClassName={"Exception"})
   public InsertPrescriptionJB update(InsertPrescriptionJB ip) {
      
      prescriptionMedicationR.deleteByIdPrescription(ip.getIdPrescriptionNum());
      Prescription p = prescriptionR.findOne(ip.getIdPrescriptionNum());
      List<PrescriptionMedication> lpm = new ArrayList<>();
      Map<Long, PM> mapPM = new HashMap<>();
      
      for(PM pm : ip.getPrescriptionMedicationList()){
         
         PrescriptionMedication pme = new PrescriptionMedication(new PrescriptionMedicationPK(p.getIdPrescriptionNum(), pm.getIdMedicationNum()),
            pm.getTxtFrequency(), pm.getTxtDosage());
         pme.setMedication(new Medication(pm.getIdMedicationNum()));
         mapPM.put(pm.getIdMedicationNum(), pm);
         lpm.add(pme);
         
      }
      
      p.setPrescriptionMedicationCollection(lpm);
      p.setDtLastUpdate(new Date(System.currentTimeMillis()));
      p = prescriptionR.save(p);
      
      ip.setPrescriptionMedicationList(null);
      ip.setAgePatient(DateUtils.calcAge(p.getIdPatientTxtCpf().getDtBirth().getTime()));
      ip.setDtBirthPatient(DateUtils.SDF_WITHOUT_HOUR.format(p.getIdPatientTxtCpf().getDtBirth()));
      ip.setDtLastUpdatePrescription(DateUtils.SDF_WITH_HOUR.format(p.getDtLastUpdate()));
      ip.setIdPatientTxtCpf(p.getIdPatientTxtCpf().getIdPatientTxtCpf());
      ip.setTxtNamePatient(p.getIdPatientTxtCpf().getTxtName());
      
      for(PrescriptionMedication pme : p.getPrescriptionMedicationCollection())
         mapPM.get(pme.getPrescriptionMedicationPK().getIdMedicationNum()).setTxtNameMedication(medicationR.getOne(pme.getPrescriptionMedicationPK().getIdMedicationNum()).getTxtName());
      
      ip.setPrescriptionMedicationList(new ArrayList<>(mapPM.values()));
      ip.setStatusMessage(ReturnMessageEnum.OK.getName());
      ip.setStatusCode(ReturnMessageEnum.OK.ordinal());
      return ip;
      
   }

   
   @Override
   public InsertPrescriptionJB get(long idPrescriptionNum) {
      
      InsertPrescriptionJB ip = new InsertPrescriptionJB();
      
      try{
         
         Prescription p = prescriptionR.getOne(idPrescriptionNum);
         ip.setDtBirthPatient(DateUtils.SDF_WITHOUT_HOUR.format(p.getIdPatientTxtCpf().getDtBirth()));
         ip.setDtLastUpdatePrescription(DateUtils.SDF_WITH_HOUR.format(p.getDtLastUpdate()));
         ip.setIdPatientTxtCpf(p.getIdPatientTxtCpf().getIdPatientTxtCpf());
         ip.setIdPrescriptionNum(p.getIdPrescriptionNum());
         ip.setTxtNamePatient(p.getIdPatientTxtCpf().getTxtName());
         ip.setAgePatient(DateUtils.calcAge(p.getIdPatientTxtCpf().getDtBirth().getTime()));
         List<PM> lpm = new ArrayList<>();

         for(PrescriptionMedication pme : p.getPrescriptionMedicationCollection()){

            PM pm = new PM();
            pm.setIdMedicationNum(pme.getMedication().getIdMedicationNum());
            pm.setTxtDosage(pme.getTxtDosage());
            pm.setTxtFrequency(pme.getTxtFrequency());
            pm.setTxtNameMedication(pme.getMedication().getTxtName());
            lpm.add(pm);

         }

         ip.setPrescriptionMedicationList(lpm);
         ip.setStatusMessage(ReturnMessageEnum.OK.getName());
         ip.setStatusCode(ReturnMessageEnum.OK.ordinal());
         return ip;
         
      }catch(EntityNotFoundException e){
         
         ip.setIdPrescriptionNum(idPrescriptionNum);
         ip.setStatusMessage(ReturnMessageEnum.NOT_EXISTS.getName());
         ip.setStatusCode(ReturnMessageEnum.NOT_EXISTS.ordinal());
         return ip;
         
      }

   }
   

}