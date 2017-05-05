## Eteg's Challenge - Back-End Developer 
* [Challenge pdf file description here](https://github.com/heronsanches/eteg-challenge/blob/master/docs/Desafio-Desenvolvedor_Back_End.pdf)

### Environment Development
* Netbeans 8.2
* OpenJDK 1.8
* Apache Maven 3.3.9 
* Fedora 25
* SQL Power Architect 1.0.8
### Project Specifications
* Spring Boot
* [pom.xml here](https://github.com/heronsanches/eteg-challenge/blob/master/pom.xml)
* [SpringBootApplication Class here](https://github.com/heronsanches/eteg-challenge/blob/master/src/main/java/com/eteg/heronsanches/eteg/HealthRestApplication.java)
* [REST Class Service here](https://github.com/heronsanches/eteg-challenge/blob/master/src/main/java/com/eteg/heronsanches/eteg/restservice/PatientRS.java)
* [Relational Model pdf file here](https://github.com/heronsanches/eteg-challenge/blob/master/database-files/rm_eteg_challenge.pdf)
* [Relational Model SQL Power Architect file here](https://github.com/heronsanches/eteg-challenge/blob/master/database-files/rm_eteg_challenge.architect)
### Running Project
1. Open a terminal
1. Go to project's root folder
1. mvn clean spring-boot:run
### Test Example
* curl -H "Content-Type: application/json" -X POST http://localhost:8080/ws.api/health/patient -d '{"idPatientTxtCpf":"39584390040", "txtName":"Test Curl 5", "dtBirth":1235962800000}'
* curl http://localhost:8080/ws.api/health/patient?cpf=39584390040
* curl -H "Content-Type: application/json" -X POST http://localhost:8080/ws.api/health/patient/prescription -d '{"idPatientTxtCpf":"39584390040", "prescriptionMedicationList":[{"idMedicationNum":1, "txtFrequency":"a cada 6h", "txtDosage":"2mg"}, { "idMedicationNum":10, "txtFrequency":"a cada 12h", "txtDosage":"250mg"}, {"idMedicationNum":303, "txtFrequency":"a cada 24h", "txtDosage":"750mg"}]}'
* curl http://localhost:8080/ws.api/health/patient/prescription?idPrescription=1
* curl -H "Content-Type: application/json" -X PUT http://localhost:8080/ws.api/health/patient/prescription -d '{"idPrescriptionNum":1, "prescriptionMedicationList":[{"idMedicationNum":145, "txtFrequency":"a cada 7h", "txtDosage":"25mg"}, { "idMedicationNum":120, "txtFrequency":"a cada 12h", "txtDosage":"20mg"}, {"idMedicationNum":3, "txtFrequency":"a cada 24h", "txtDosage":"75mg"}]}'
* curl http://localhost:8080/ws.api/health/patient/prescription?idPrescription=1
