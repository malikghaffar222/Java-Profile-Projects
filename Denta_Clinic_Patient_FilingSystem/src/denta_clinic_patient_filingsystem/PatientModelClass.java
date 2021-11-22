/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package denta_clinic_patient_filingsystem;

/**
 *
 * @author Dell
 */
public class PatientModelClass {
    String name, gender, phone, email, dateOfBirth, insuranceCompany, idNumber, nationality;
    int fileNo;

    public PatientModelClass(String name, String gender, String phone, String email, String dateOfBirth, String insuranceCompany, String idNumber, 
            String nationality, int fileNo) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.insuranceCompany = insuranceCompany;
        this.idNumber = idNumber;
        this.nationality = nationality;
        this.fileNo = fileNo;
    }

    public PatientModelClass() {
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }
}
