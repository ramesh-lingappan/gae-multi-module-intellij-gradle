package com.rameshl.demo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rameshl.demos.service.GreetingService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MultiModules
 * Created by Ramesh on 8/21/17.
 */

@WebServlet("/api/v1/greet")
public class GreetApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GreetingService greetingService = new GreetingService();
        ObjectMapper objMapper = new ObjectMapper();

        Map<String, Object> response = new HashMap<>();

        response.put("ok", true);
        response.put("greeting", greetingService.getGreetings("API"));

        String json = objMapper.writeValueAsString(response);

        resp.setContentType("application/json");
        resp.getWriter().println(json);
    }
}
