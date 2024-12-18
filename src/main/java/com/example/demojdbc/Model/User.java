package com.example.demojdbc.Model;

public class User {
    private int id;
    private String name;
    private String phone;
    private String password;
    private String address;

    public User() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public User(int id, String name, String phone, String password, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.address = address;
    }
    public User(String name, String phone, String password, String address) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
