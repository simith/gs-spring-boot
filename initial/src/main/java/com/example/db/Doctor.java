package com.example.db;

public class Doctor {
    String name;
    String speciality;
    int id;

    public Doctor(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor(int id, String pName, String pSpeciality){
        this.id = id;
        this.name = pName;
        this.speciality = pSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
