package com.example.soda_workshop;

public class User {
    private String name;
    private String asurite;
    private String number;

    public User() {
    }

    public User(String name, String asurite, String number) {
        this.name = name;
        this.asurite = asurite;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsurite() {
        return asurite;
    }

    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

