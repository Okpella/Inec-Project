package com.prof.inec.model;

import java.util.Date;
import java.util.Objects;

public class Voter {
    private String id;
    private String fisrtName;
    private String lastName;
    private String voterOtherNames;
    private Lga lga;
    private RegistrationPoint registrationPoint;
    private Date dob;
    private String address;
    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVoterOtherNames() {
        return voterOtherNames;
    }

    public void setVoterOtherNames(String voterOtherNames) {
        this.voterOtherNames = voterOtherNames;
    }

    public Lga getLga() {
        return lga;
    }

    public void setLga(Lga lga) {
        this.lga = lga;
    }

    public RegistrationPoint getRegistrationPoint() {
        return registrationPoint;
    }

    public void setRegistrationPoint(RegistrationPoint registrationPoint) {
        this.registrationPoint = registrationPoint;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return id == voter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
