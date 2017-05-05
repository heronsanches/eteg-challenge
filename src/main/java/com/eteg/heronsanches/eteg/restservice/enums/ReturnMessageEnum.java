package com.eteg.heronsanches.eteg.restservice.enums;

/**
 *
 * @author Heron Sanches
 */
public enum ReturnMessageEnum {
   
   OK("OK"), 
   ALREADY_EXISTS("Já existe"),
   ERROR("Erro"),
   NOT_EXISTS("Não existe");
   
   private String name;
   
   
   private ReturnMessageEnum(String name){
      this.name = name;
   }

   
   public String getName() {
      return name;
   }
   
   
}