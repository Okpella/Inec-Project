package com.prof.inec.model;

import java.util.Objects;

public class Candidate extends Voter {
    private String candidateId;
    private String candidateName;
    private String position;
    private String mate;
    private Party candidateParty;
//    private String image;


    public Candidate(String candidateId, String candidateName, String position,
                     Party candidateParty, String mate) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.position = position;
        this.mate = mate;
        this.candidateParty = candidateParty;
//        this.image = image;

    }

    public Candidate(){}

    public String getCandidateId(){
        return candidateId;
    }

    public void setCandidateId(String candidateId){
        this.candidateId = candidateId;
    }

    public Party getCandidateParty(){
        return candidateParty;
    }

    public void setCandidateParty(Party candidateParty){
        this.candidateParty = candidateParty;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public void setCandidateName(String candidateName){
        this.candidateName = candidateName;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getMate(){
        return mate;
    }

    public void setMate(String mate){
        this.mate = mate;
    }

//    public String getImage() {
//        return image;
//    }

//    public void setImage(String image) {
//        this.image = image;
//    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Candidate candidate = (Candidate) o;
//        return Objects.equals(candidateId, candidate.candidateId);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(candidateId);
//
//    }

    @Override
    public String toString(){
        return candidateName;
    }

}


