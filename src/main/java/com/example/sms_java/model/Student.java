package com.example.sms_java.model;

public class Student {

    private int id;
    private String regNo;
    private String name;
    private String course;

    public Student(int id, String regNo, String name, String course) {
        this.id = id;
        this.regNo = regNo;
        this.name = name;
        this.course = course;
    }

    public Student(String regNo, String name, String course) {
        this(0, regNo, name, course);
    }

    public int getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
