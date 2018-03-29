package com.learncamel.domain;

public class Employee {

    private Long id;
    private String joinDate;
    private String name;

    public Long getId() {
        return id;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", joinDate='" + joinDate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
