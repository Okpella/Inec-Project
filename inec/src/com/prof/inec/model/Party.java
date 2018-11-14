package com.prof.inec.model;

public class Party {
    private String name;
    private  String id;

//    CONSTRUCTORS
    public Party(String name, String id){
        this.name = name;
        this.id = id;
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
