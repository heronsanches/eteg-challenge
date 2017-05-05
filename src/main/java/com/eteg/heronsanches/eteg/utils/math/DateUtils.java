package com.eteg.heronsanches.eteg.utils.math;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Heron Sanches
 */
public final class DateUtils {
   
   public static final SimpleDateFormat SDF_WITH_HOUR = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
   public static final SimpleDateFormat SDF_WITHOUT_HOUR = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

   
   private DateUtils(){}
   
   
   /**Calculates your age based on you birthDate at milliseconds and on local datetime in milliseconds.
    * @return : the integer floor age. Ex.: 30.8 returns 30.
    @param birthDate : the birth date at milliseconds.*/
   public static int calcAge(long birthDate){
      
      double current = System.currentTimeMillis();
      current /= 1000;
      current /= 60;
      current /= 60;
      current /= 24;
      current /= 365;
      
      double age = birthDate;
      age /= 1000;
      age /= 60;
      age /= 60;
      age /= 24;
      age /= 365;
      
      return Integer.valueOf(String.valueOf(Math.floor(current - age)).split("\\.")[0]);
      
   }
   
   
}