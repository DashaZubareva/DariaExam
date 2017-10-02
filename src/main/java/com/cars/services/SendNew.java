package com.cars.services;

import com.cars.base.Car;
import com.cars.dao.DBConnect;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sit on 28.09.2017.
 */

@WebServlet("/sendNew")
public class SendNew extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int year = Integer.parseInt(req.getParameter("year"));
        String color = req.getParameter("color");
        List<Car> cars = new ArrayList<>();
        DBConnect dbw = new DBConnect();
        try {
            int res = dbw.insertCar(year, name, color);
            cars = dbw.getSold();
        } catch (SQLException e) {
            e.getMessage();
        }

        req.setAttribute("cars", cars);
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("catalogCars.jsp").forward(req, resp);

    }
}