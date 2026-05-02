package com.umbb.mobguide.model;

import java.util.ArrayList;

public class Faculty {
    private int id;
    private String name;
    private String description;
    private String email;
    private String phone;
    private String address;
    private double latitude;
    private double longitude;
    private ArrayList<Department> departments;

    public Faculty(int id, String name, String description,
                   String email, String phone, String address,
                   double latitude, double longitude,
                   ArrayList<Department> departments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.departments = departments;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public ArrayList<Department> getDepartments() { return departments; }
}
