package com.cars.dao;

import com.cars.base.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sit on 28.09.2017.
 */
public class DBConnect {
    private Connection connection = null;

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/storage";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public DBConnect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }catch (ClassNotFoundException e){
            e.getMessage();
        }catch (SQLException e){
            e.getMessage();
        }

    }
    public List<Car> getSold() throws SQLException {
        List<Car> result = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM cars WHERE status='NS'");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            result.add(new Car(rs));
        }
        return result;
    }

    public List<Car> getAll() throws SQLException {
        List<Car> result = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM cars");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            result.add(new Car(rs));
        }
        return result;
    }

    public int insertCar(int year, String name, String color) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO cars (year,name,color,status) VALUES (?,?,?,'NS')", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,year);
        ps.setString(2,name);
        ps.setString(3,color);
        if(ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return (int) rs.getLong(1);
        }
        throw new SQLException("Failed to insert");
    }

    public Boolean toSell(int year) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE cars SET status='S' WHERE year=?");
        ps.setInt(1,year);
        return ps.executeUpdate() > 0;
    }

      public Boolean deleteCar(int year) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM cars WHERE status='S' AND year=?");
        ps.setInt(1,year);
        return ps.executeUpdate() > 0;
    }

    public Boolean createTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("CREATE TABLE cars (year INTEGER NOT NULL, name character varying, color character varying, status character varying)");
        return ps.execute();
    }

}