package com.yovelas.entity;

public class Classfy {
    private int id;
    private String name;

    public Classfy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Classfy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classfy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
