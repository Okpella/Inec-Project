package com.prof.inec.model;

public class Party {
    private String name;
    private  String id;
    private String passport;

//    CONSTRUCTORS
    public Party(String name, String id, String passport){
        this.name = name;
        this.id = id;
        this.passport = passport;
    }

    public Party(){}

    public Party(Party candidateParty){

    }

//    GETTERS AND SETTERS
    public String getName(){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getId(){
        return  id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Party party = (Party) o;

        return id == party.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString(){
        return name + " " + id;
    }
}
