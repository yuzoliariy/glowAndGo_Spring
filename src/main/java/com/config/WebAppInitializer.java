package com.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.scan("com");
        servletContext.addListener(new ContextLoaderListener(applicationContext));
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("mvc",new DispatcherServlet(new GenericWebApplicationContext()));
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/");
    }
}
