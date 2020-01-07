package com.majun.pojo;

public class MyGoddess {
    private int id;
    private String name;
    private Double wage;


    public MyGoddess() {
    }

    public MyGoddess(String name, Double wage, int id) {
        this.name = name;
        this.wage = wage;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyGoddess{" +
                "name='" + name + '\'' +
                ", wage=" + wage +
                ", id=" + id +
                '}';
    }
}
