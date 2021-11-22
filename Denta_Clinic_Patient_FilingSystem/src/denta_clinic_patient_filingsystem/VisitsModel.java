/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package denta_clinic_patient_filingsystem;

public class VisitsModel {
    String patientName;
    String date;
    int file;
    String treatmentProcedure;
    int treatmentPrice;

    public VisitsModel(String patientName, String date, int file, String treatmentProcedure, int treatmentPrice) {
        this.patientName = patientName;
        this.date = date;
        this.file = file;
        this.treatmentProcedure = treatmentProcedure;
        this.treatmentPrice = treatmentPrice;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDate() {
        return date;
    }

    public int getFile() {
        return file;
    }

    public String getTreatmentProcedure() {
        return treatmentProcedure;
    }

    public int getTreatmentPrice() {
        return treatmentPrice;
    }

    public String toString(){
        return "Name: "+this.patientName+"\nVisitingDate: "+this.date+"\nTreatment Procedure: "+this.treatmentProcedure+"\nPrice: "+this.treatmentPrice;
    }
}
