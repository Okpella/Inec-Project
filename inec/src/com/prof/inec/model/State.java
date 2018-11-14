package com.prof.inec.model;

import java.util.Objects;

public class State {
    private String stateId;
    private String stateName;

    public State(String stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public State() {
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(stateId, state.stateId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stateId);
    }

    @Override
    public String toString(){
        return this.stateName;
    }
}
