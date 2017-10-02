package com.cars.services;

import com.cars.dao.DBConnect;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sit on 28.09.2017.
 */

@WebServlet("/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int year = Integer.parseInt(req.getParameter("year"));
        try{
            DBConnect dbw = new DBConnect();
            Boolean res = dbw.deleteCar(year);
            resp.setContentType("application/json");
            resp.getWriter().println((new Gson()).toJson(res));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
