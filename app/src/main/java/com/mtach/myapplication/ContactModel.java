package com.mtach.myapplication;


public class ContactModel{

    private int id ;
    private String name;
    private String phone;
    private String email;

    public ContactModel(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public ContactModel() {

    }

    public int getId() {
        return id;
    }

    public ContactModel setId(int id) {
        this.id = id;
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
