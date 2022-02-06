package com.example.hosptialtag.pojo;

public class Patient {

    private int patient_id;
    private int patient_age;
    private String patient_name;
    private String patient_idcard;
    private String patient_phone;

    public Patient(int patient_id, int patient_age, String patient_name, String patient_idcard, String patient_phone) {
        this.patient_id = patient_id;
        this.patient_age = patient_age;
        this.patient_name = patient_name;
        this.patient_idcard = patient_idcard;
        this.patient_phone = patient_phone;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_idcard() {
        return patient_idcard;
    }

    public void setPatient_idcard(String patient_idcard) {
        this.patient_idcard = patient_idcard;
    }

    public String getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_age=" + patient_age +
                ", patient_name='" + patient_name + '\'' +
                ", patient_idcard='" + patient_idcard + '\'' +
                ", patient_phone='" + patient_phone + '\'' +
                '}';
    }
}
