package org.example;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class App {
    private static final String DEFAULT_PORT = "8080";

    public static void main(final String... args) throws Exception {
        final ServletContextHandler context = new ServletContextHandler();
        context.addServlet(new ServletHolder(new SpringServlet()), "/*");
        context.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", Boolean.toString(true));
        context.addEventListener(new ContextLoaderListener());
//        context.addEventListener(new RequestContextListener());
        context.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        context.setInitParameter("contextConfigLocation", AppConfig.class.getName());

        final Server server = new Server(Integer.parseInt(System.getProperty("port", DEFAULT_PORT)));
        server.setHandler(context);
        server.start();
        server.join();
    }
}