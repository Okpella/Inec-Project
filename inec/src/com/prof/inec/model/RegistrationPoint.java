package com.prof.inec.model;

import java.util.Objects;

public class RegistrationPoint {
    private int id;
    private String regPoint;
    private Lga lga;

    public RegistrationPoint(){}

    public RegistrationPoint(int id, String regPoint, Lga lga){
        this.id = id;
        this.regPoint = regPoint;
        this.lga = lga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegPoint() {
        return regPoint;
    }

    public void setRegPoint(String regPoint) {
        this.regPoint = regPoint;
    }

    public Lga getLga() {
        return lga;
    }

    public void setLga(Lga lga) {
        this.lga = lga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationPoint that = (RegistrationPoint) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return regPoint;
    }
}
