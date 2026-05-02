package com.umbb.mobguide.model;

import java.util.ArrayList;

public class Department {
    private int id;
    private String name;
    private String description;
    private ArrayList<String> specialties;
    private String email;
    private String phone;

    public Department(int id, String name, String description,
                      ArrayList<String> specialties, String email, String phone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.specialties = specialties;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public ArrayList<String> getSpecialties() { return specialties; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
