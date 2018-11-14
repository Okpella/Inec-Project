package com.prof.inec.model;

import java.util.Objects;

public class Lga {
    private Integer lgaId;
    private String stateId;
    private State state;
    private String lgaName;

    public Lga(Integer lgaId, String stateId, String lgaName) {
        this.lgaId = lgaId;
        this.stateId = stateId;
        this.lgaName = lgaName;
    }

    public Lga(){}

    public Integer getLgaId() {
        return lgaId;
    }

    public void setLgaId(Integer lgaId) {
        this.lgaId = lgaId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getLgaName() {
        return lgaName;
    }

    public void setLgaName(String lgaName) {
        this.lgaName = lgaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lga lga = (Lga) o;
        return Objects.equals(lgaId, lga.lgaId) &&
                Objects.equals(stateId, lga.stateId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lgaId, stateId);
    }

    @Override
    public String toString(){
        return this.lgaName;
    }
}
