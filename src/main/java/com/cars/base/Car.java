package com.cars.base;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sit on 28.09.2017.
 */
public class Car {
    private int year;
    private String name;
    private String color;
    private String status;

    public int getYear() {
        return year;
    }

    public void setYear(int age) {
        this.year = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car(int year, String name, String color, String status) {
        this.year = year;
        this.name = name;
        this.color = color;
        this.status = status;
    }
    public Car(ResultSet rs) throws SQLException {
        year = rs.getInt("year");
        name = rs.getString("name");
        color = rs.getString("color");
        status = rs.getString("status");
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + year +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
