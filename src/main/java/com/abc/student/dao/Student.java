package com.abc.student.dao;

public class Student {
	
	private String registrationNumber;
    private String name;
    private String email;
    private int attendance;
    private int percentage;
    private String branch;
    public Student(String registrationNumber, String name, String email, int attendance, int percentage, String branch) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.email = email;
        this.attendance = attendance;
        this.percentage = percentage;
        this.branch = branch;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAttendance() {
        return attendance;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getBranch() {
        return branch;
    }
}
