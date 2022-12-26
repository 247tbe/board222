package com.nhnacademy.nhnboard.command;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (!Objects.isNull(session)) {
            session.invalidate();
        }

        return "loginForm.jsp";
    }
}
