package com.rameshl.demo.servlets;

import com.rameshl.demos.service.GreetingService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MultiModules
 * Created by Ramesh on 8/21/17.
 */
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // service from common module
        GreetingService greetingService = new GreetingService();

        resp.getWriter().println(greetingService.getGreetings("Module"));
    }
}
