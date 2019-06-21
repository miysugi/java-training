package com.samuraism.training.servlet;

import com.samuraism.training.model.Fizz;
import com.samuraism.training.model.FizzBuzzController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private TemplateEngine templateEngine;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }


    @Inject
    FizzBuzzController fizzBuzz;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String number = req.getParameter("number");
        int numberInt = 100;
        try {
            numberInt = Integer.parseInt(number);
        } catch (NumberFormatException | NullPointerException ignored) {
        }
        final List<Fizz> fizzList = fizzBuzz.persistFizzBuzz(numberInt);

        HashMap<String, Object> map = new HashMap<>();
        map.put("fizzList", fizzList);

        WebContext webContext = new WebContext(req, resp, getServletContext(), req.getLocale());
        webContext.setVariables(map);
        Writer writer = new OutputStreamWriter(resp.getOutputStream(), StandardCharsets.UTF_8);
        templateEngine.process("index", webContext, writer);

    }
}
