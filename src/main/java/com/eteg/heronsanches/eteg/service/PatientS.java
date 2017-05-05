package com.eteg.heronsanches.eteg.service;

import com.eteg.heronsanches.eteg.entity.Patient;
import com.eteg.heronsanches.eteg.jparepositiry.PatientR;
import com.eteg.heronsanches.eteg.restservice.enums.ReturnMessageEnum;
import com.eteg.heronsanches.eteg.restservice.jsonbind.patient.PatientJB;
import com.eteg.heronsanches.eteg.utils.math.DateUtils;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Heron Sanches
 */
@Service("patientS")
public class PatientS implements PatientSI{

   @Autowired
   private PatientR patientR;
   
   
   @Override
   public PatientJB findByIdPatientTxtCpf(String idPatientTxtCpf) {
      
      Patient p = patientR.findByIdPatientTxtCpf(idPatientTxtCpf);
      PatientJB pjb = new PatientJB();
      
      if(p != null){
         
         pjb.setAge(DateUtils.calcAge(p.getDtBirth().getTime()));
         pjb.setDtBirth(DateUtils.SDF_WITHOUT_HOUR.format(p.getDtBirth()));
         pjb.setDtLastUpdate(DateUtils.SDF_WITH_HOUR.format(p.getDtLastUpdate()));
         pjb.setDtRegister(DateUtils.SDF_WITH_HOUR.format(p.getDtRegister()));
         pjb.setIdPatientTxtCpf(p.getIdPatientTxtCpf());
         pjb.setTxtName(p.getTxtName());
         pjb.setStatusMessage(ReturnMessageEnum.OK.getName());
         pjb.setStatusCode(ReturnMessageEnum.OK.ordinal());
         return pjb;
         
      }
      
      pjb.setIdPatientTxtCpf(idPatientTxtCpf);
      pjb.setStatusMessage(ReturnMessageEnum.NOT_EXISTS.getName());
      pjb.setStatusCode(ReturnMessageEnum.NOT_EXISTS.ordinal());
      return pjb;
      
   }

   
   @Override
   @Transactional(rollbackForClassName={"Exception"})
   public PatientJB insert(Patient patient) {
      
      Patient p = patientR.findByIdPatientTxtCpf(patient.getIdPatientTxtCpf());
      PatientJB pjb = new PatientJB();
      
      if(p == null){
         
         Date d = new Date(System.currentTimeMillis());
         patient.setDtRegister(d);
         patient.setDtLastUpdate(d);
         p = patientR.save(patient);
         pjb = new PatientJB();
         pjb.setAge(DateUtils.calcAge(p.getDtBirth().getTime()));
         pjb.setDtBirth(DateUtils.SDF_WITHOUT_HOUR.format(p.getDtBirth()));
         pjb.setDtLastUpdate(DateUtils.SDF_WITH_HOUR.format(p.getDtLastUpdate()));
         pjb.setDtRegister(DateUtils.SDF_WITH_HOUR.format(p.getDtRegister()));
         pjb.setIdPatientTxtCpf(p.getIdPatientTxtCpf());
         pjb.setTxtName(p.getTxtName());
         pjb.setStatusMessage(ReturnMessageEnum.OK.getName());
         pjb.setStatusCode(ReturnMessageEnum.OK.ordinal());
         return pjb;
         
      }
      
      pjb.setAge(DateUtils.calcAge(p.getDtBirth().getTime()));
      pjb.setDtBirth(DateUtils.SDF_WITHOUT_HOUR.format(p.getDtBirth()));
      pjb.setDtLastUpdate(DateUtils.SDF_WITH_HOUR.format(p.getDtLastUpdate()));
      pjb.setDtRegister(DateUtils.SDF_WITH_HOUR.format(p.getDtRegister()));
      pjb.setIdPatientTxtCpf(p.getIdPatientTxtCpf());
      pjb.setTxtName(p.getTxtName());
      pjb.setStatusMessage(ReturnMessageEnum.ALREADY_EXISTS.getName());
      pjb.setStatusCode(ReturnMessageEnum.ALREADY_EXISTS.ordinal());
      return pjb;
      
   }

   
}