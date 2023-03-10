package com.nhnacademy.nhnboard.command;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (!Objects.isNull(session)) {
            String id = (String) session.getAttribute("loginID");

            if (!Objects.isNull(id)) {
                return "login.jsp";
            }
        }

        return "loginForm.jsp";
    }
}
