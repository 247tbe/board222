package com.nhnacademy.nhnboard.servlet;

import com.nhnacademy.nhnboard.command.ChangeLanguageCommand;
import com.nhnacademy.nhnboard.command.Command;
import com.nhnacademy.nhnboard.command.IndexCommand;
import com.nhnacademy.nhnboard.command.InitCommand;
import com.nhnacademy.nhnboard.command.LoginCommand;
import com.nhnacademy.nhnboard.command.LoginFormCommand;
import com.nhnacademy.nhnboard.command.LogoutCommand;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "frontServlet", urlPatterns = "*.do")
@Slf4j
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String lang = (String) req.getSession().getAttribute("lang");
        req.setAttribute("lang", lang);
        log.info(lang);

        try {
            Command command = resolveServlet(req.getServletPath());

            String view = command.execute(req, resp);
            log.info(view);

            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception e) {
            log.error("", e);
            req.setAttribute("exception", e);

            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveServlet(String servletPath) {
        Command command = null;

        if ("/index.do".equals(servletPath)) {
            command = new IndexCommand();
        } else if ("/change-lang.do".equals(servletPath)) {
            command = new ChangeLanguageCommand();
        } else if ("/login.do".equals(servletPath)) {
            command = new LoginCommand();
        } else if ("/loginForm.do".equals(servletPath)) {
            command = new LoginFormCommand();
        } else if ("/logout.do".equals(servletPath)) {
            command = new LogoutCommand();
        } else if ("/init.do".equals(servletPath)) {
            command = new InitCommand();
        }

        return command;
    }
}
