package com.majun.Spring.springServlet;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request中获取servletContext
        ServletContext servletContext = request.getServletContext();
        //通过servletContext获取容器
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        //通过容器获取一个对象
        System.out.println(context.getBean("userServiceImp1"));
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }
}
