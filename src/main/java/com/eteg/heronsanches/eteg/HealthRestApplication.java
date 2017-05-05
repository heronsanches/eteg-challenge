package com.eteg.heronsanches.eteg;

import com.eteg.heronsanches.eteg.entity.Medication;
import com.eteg.heronsanches.eteg.entity.Patient;
import com.eteg.heronsanches.eteg.jparepositiry.MedicationR;
import com.eteg.heronsanches.eteg.jparepositiry.PatientR;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 *
 * @author Heron Sanches
 */
@SpringBootApplication
public class HealthRestApplication {
   
   
   public static void main(String args[]){
      SpringApplication.run(HealthRestApplication.class, args);
   }
   
   
   @Bean
   public CommandLineRunner initializeData(PatientR patientR, MedicationR medicationR){
      
      return (evt) -> {
         Date d = new Date(System.currentTimeMillis());
         patientR.save(new Patient("72535602059", "Test 1", new GregorianCalendar(2000, Calendar.JANUARY, 21).getTime(), d, d));
         
         d = new Date(System.currentTimeMillis());
         patientR.save(new Patient("77191442018", "Test 2", new GregorianCalendar(2004, Calendar.JUNE, 1).getTime(), d, d));
         
         d = new Date(System.currentTimeMillis());
         patientR.save(new Patient("97389642025", "Test 3", new GregorianCalendar(2009, Calendar.MARCH, 2).getTime(), d, d));
         
         d = new Date(System.currentTimeMillis());
         patientR.save(new Patient("97905493008", "Test 4", new GregorianCalendar(2015, Calendar.OCTOBER, 11).getTime(), d, d));
         
         for(int i=1; i<500; i++){
            medicationR.save(new Medication("Medication "+i));
         }
         
         LoggerFactory.getLogger(HealthRestApplication.class).info("Data sample was generated!");
      };
      
   }
   
   
}