package com.cars.services;

import com.cars.base.Car;
import com.cars.dao.DBConnect;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sit on 28.09.2017.
 */
@WebServlet("/sell")
public class ToSell  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int year = Integer.parseInt(req.getParameter("year"));
        List<Car> cars = new ArrayList<>();
        try{
            DBConnect dbw = new DBConnect();
            Boolean res = dbw.toSell(year);
            cars = dbw.getSold();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("catalogCars.jsp").forward(req, resp);
    }
}